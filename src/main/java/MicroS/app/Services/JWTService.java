package MicroS.app.Services;

import MicroS.app.Persistence.Entities.Usuario;

public interface JWTService {

    //Méotodo que genere un token para un usuario
    public String generateToken(Usuario usuario);
    public String generateRefreshToken(Usuario usuario);

}
