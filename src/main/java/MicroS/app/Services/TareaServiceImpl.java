package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Tarea;
import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Persistence.Repositories.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService {

    private TareaRepository tareaRepository;
    
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    private UsuarioService usuarioService;

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

}
