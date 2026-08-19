package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final TareaService tareaService;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            TareaService tareaService) {

        this.usuarioRepository = usuarioRepository;
        this.tareaService = tareaService;
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

        Usuario usuarioExistente =
                usuarioRepository.findByUsername(usuario.getUsername());

        if (usuarioExistente == null) {
            return null;
        }

        usuarioExistente.setNombre(usuario.getNombre());
        usuarioExistente.setPassword(usuario.getPassword());

        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public Usuario deleteUsuario(String username) {

        Usuario usuario =
                usuarioRepository.findByUsername(username);

        if (usuario == null) {
            return null;
        }

        tareaService.deleteTareaByUsuario(usuario.getId());
        usuarioRepository.delete(usuario);

        return usuario;
    }
}