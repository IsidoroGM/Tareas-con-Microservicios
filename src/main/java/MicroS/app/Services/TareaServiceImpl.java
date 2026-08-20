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

    private TareaRepository tareaRepository;
    
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    
    private TipoRepository tipoRepository;
    private UsuarioService usuarioService;
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Tarea> deleteTareaByUsuario(Integer id) {
        
        List<Tarea> tareas = tareaRepository.findAllByUsuario_id(id);

        for(Tarea t:tareas){
            tareaRepository.delete(t);
        }

        return tareas;
    }

    @Override
    public List<Tarea> deleteTareabyTipoid(Integer id) {

        List<Tarea> tareas = tareaRepository.findAllByTipo_id(id);

        for(Tarea t:tareas){
            tareaRepository.delete(t);
        }

        return tareas;
    }

    @Override
    public List<Tarea> getTareas(String username) {
        Usuario usuario = usuarioService.getUsuario(username);
        return tareaRepository.findAllByUsuario_id(usuario.getId());
    }

    @Override
    public Tarea addTarea(String username, String tipo, Tarea tarea) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if ((usuario != null)) {
            Tipo t= tipoRepository.findByNombre(tipo);
            if (t != null){
                tarea.setRealizada(false);
                tarea.setUsuario(usuario);
                LocalDate today=LocalDate.now();
                tarea.setFecha(today);
                tarea.setTipo(t);
                return tareaRepository.save(tarea);
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

}
