package MicroS.app.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Tarea;
import MicroS.app.Persistence.Entities.Tipo;
import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Repositories.TareaRepository;
import MicroS.app.Persistence.Repositories.TipoRepository;
import MicroS.app.Persistence.Repositories.UsuarioRepository;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;
    private final TipoRepository tipoRepository;
    private final UsuarioRepository usuarioRepository;

    public TareaServiceImpl(
            TareaRepository tareaRepository,
            TipoRepository tipoRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.tareaRepository = tareaRepository;
        this.tipoRepository = tipoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Tarea> deleteTareaByUsuario(Integer id) {

        List<Tarea> tareas =
                tareaRepository.findAllByUsuario_id(id);

        for (Tarea tarea : tareas) {
            tareaRepository.delete(tarea);
        }

        return tareas;
    }

    @Override
    public List<Tarea> deleteTareabyTipoid(Integer id) {

        List<Tarea> tareas =
                tareaRepository.findAllByTipo_id(id);

        for (Tarea tarea : tareas) {
            tareaRepository.delete(tarea);
        }

        return tareas;
    }

    @Override
    public List<Tarea> getTareas(String username) {

        Usuario usuario =
                usuarioRepository.findByUsername(username);

        if (usuario == null) {
            return List.of();
        }

        return tareaRepository.findAllByUsuario_id(
                usuario.getId()
        );
    }

    @Override
    public Tarea addTarea(
            String username,
            String tipo,
            Tarea tarea
    ) {
        Usuario usuario =
                usuarioRepository.findByUsername(username);

        if (usuario == null) {
            return null;
        }

        Tipo tipoEncontrado =
                tipoRepository.findByNombre(tipo);

        if (tipoEncontrado == null) {
            return null;
        }

        tarea.setRealizada(false);
        tarea.setUsuario(usuario);
        tarea.setFecha(LocalDate.now());
        tarea.setTipo(tipoEncontrado);

        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea deleteTarea(Integer id) {

        Tarea tarea =
                tareaRepository.findById(id).orElse(null);

        if (tarea != null) {
            tareaRepository.delete(tarea);
        }

        return tarea;
    }

    @Override
    public List<Tarea> getTareas(
            String username,
            LocalDate fecha
    ) {
        Usuario usuario =
                usuarioRepository.findByUsername(username);

        if (usuario == null) {
            return List.of();
        }

        return tareaRepository.findAllByFechaAndUsuario_Id(
                fecha,
                usuario.getId()
        );
    }
}