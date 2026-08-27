package MicroS.app.Services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import MicroS.app.DTO.LoginRequest;
import MicroS.app.DTO.TokenResponse;
import MicroS.app.Persistence.Entities.Token;
import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Repositories.TokenRepository;
import MicroS.app.Persistence.Repositories.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final JWTService jwtService;
    private final TokenRepository tokenRepository;
    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            PasswordEncoder passwordEncoder,
            UsuarioRepository usuarioRepository,
            JWTService jwtService,
            TokenRepository tokenRepository,
            AuthenticationManager authenticationManager) {

        this.passwordEncoder = passwordEncoder;
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenResponse register(Usuario usuario) {

        String password = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(password);
        usuarioRepository.save(usuario);
        String jwtToken = jwtService.generateToken(usuario);
        String refreshToken = jwtService.generateRefreshToken(usuario);
        saveUserToken(usuario, jwtToken);

        return new TokenResponse(jwtToken, refreshToken);
    }

    private void saveUserToken(Usuario usuario, String jwtToken) {
        Token token = new Token(jwtToken, false, false, usuario);
        tokenRepository.save(token);
    }

    @Override
    public TokenResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername());
        String jwtToken = jwtService.generateToken(usuario);
        String refreshToken = jwtService.generateRefreshToken(usuario);
        revokeAllUserToken(usuario);
        saveUserToken(usuario, jwtToken);

        return new TokenResponse(jwtToken, refreshToken);
    }

    private void revokeAllUserToken(Usuario usuario) {
        List<Token> validUserTokens = tokenRepository.findByExpiredAndRevokedAndUsuario_id(false, false, usuario.getId());

        if (!validUserTokens.isEmpty()) {
            for (Token token : validUserTokens) {
                token.setExpired(true);
                token.setRevoked(true);
            }
        }
        tokenRepository.saveAll(validUserTokens);
    }

    @Override
    public TokenResponse refresh(String authHeader) {
        // Si auth header no es null, o no empieza con "Bearer"
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new IllegalArgumentException("Invalid Bearer Token");
        }

        String refreshToken = authHeader.substring(7);
        String username = jwtService.extractUsername(refreshToken);

        if (username == null) {
            throw new IllegalArgumentException("Invalid Refresh Token");
        }

        Usuario usuario = usuarioRepository.findByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }

        if (!jwtService.isTokenVaild(refreshToken, usuario)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        String accessToken = jwtService.generateToken(usuario);
        revokeAllUserToken(usuario);
        saveUserToken(usuario, accessToken);

        return new TokenResponse(accessToken, refreshToken);
    }

}
