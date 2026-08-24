package MicroS.app.Services;

import java.util.Base64;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTServiceImpl implements JWTService {

    @Value("${application.security.jwt.secret-key}")
    private String secretKey;
    @Value("${application.security.jwt.expiration}")
    private Long jwtExpiration;
    @Value("${application.security.jwt.refresh-expiration}")
    private Long refreshExpiration;

    

    @Override
    public String generateToken(Usuario usuario) {
        return buildToken(usuario, jwtExpiration);
    }

    @Override
    public String generateRefreshToken(Usuario usuario) {
        return buildToken(usuario, refreshExpiration);
    }

    private String buildToken(Usuario usuario, long expiration) {
        return Jwts.builder()
            .id(Integer.toString(usuario.getId()))
            .claim("name", usuario.getNombre())
            .subject(usuario.getUsername())
            .issuedAt(new Date(System.currentTimeMillis()))
            .expiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSignInKey())
            .compact();
    }

    private SecretKey getSignInKey() {
        byte[] keyBytes = Base64.getDecoder().decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

   

}
