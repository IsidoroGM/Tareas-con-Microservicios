package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getUsuario() {
        return usuarioRepository.findAll();
        
    }

    @Override
    public Usuario getUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario usu=usuarioRepository.findByUsername(usuario.getUsername());
        
        //comprobamos si el usuario existe
        if(usu != null){
            usu.setNombre(usuario.getNombre());
            usu.setPassword(usuario.getPassword()); 
            return usuarioRepository.save(usu);
        }else{
            return null;
        }
    }

}
