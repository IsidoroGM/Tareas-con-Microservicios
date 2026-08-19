package MicroS.app.Services;

import java.util.List;

import MicroS.app.Persistence.Entities.Usuario;

public interface UsuarioService {

    public List<Usuario> getUsuario();

    public Usuario getUsuario(String username);

    public Usuario updateUsuario(Usuario usuario);

    public Usuario deleteUsuario(String username);

}
