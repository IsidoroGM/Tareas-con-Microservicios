package MicroS.app.Services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import MicroS.app.DTO.TokenResponse;
import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Entities.Token;
import MicroS.app.Persistence.Repositories.TokenRepository;
import MicroS.app.Persistence.Repositories.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService{


    private PasswordEncoder passwordEncoder;
    private UsuarioRepository usuarioRepository;
    private JWTService jwtService;
    private TokenRepository tokenRepository;

    @Override
    public TokenResponse register(Usuario usuario) {
        
        String password=passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(password);
        usuarioRepository.save(usuario);
        String jwtToken = jwtService.generateToken(usuario);
        String refreshToken=jwtService.generateRefreshToken(usuario);
        //guardar el token en BBDD
        saveUserToken(usuario,jwtToken);

        return new TokenResponse(jwtToken, refreshToken);
    }

    private void saveUserToken(Usuario usuario, String jwtToken){
        Token token = new Token(jwtToken, false, false, usuario);
        tokenRepository.save(token);

    }

}
