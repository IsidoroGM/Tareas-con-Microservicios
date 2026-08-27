package MicroS.app.Services;

import org.springframework.stereotype.Service;

import MicroS.app.DTO.LoginRequest;
import MicroS.app.DTO.TokenResponse;
import MicroS.app.Persistence.Entities.Usuario;

@Service
public interface AuthService {

    public TokenResponse register(Usuario usuario);
    public TokenResponse login(LoginRequest request);
    public TokenResponse refresh(String authHeader);

}
