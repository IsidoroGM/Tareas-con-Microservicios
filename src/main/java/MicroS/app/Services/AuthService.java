package MicroS.app.Services;

import org.springframework.stereotype.Service;

import MicroS.app.DTO.TokenResponse;
import MicroS.app.Persistence.Entities.Usuario;

@Service
public interface AuthService {

    public TokenResponse register(Usuario usuario);

}
