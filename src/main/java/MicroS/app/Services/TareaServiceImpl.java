package MicroS.app.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import MicroS.app.Persistence.Entities.Tarea;
import MicroS.app.Persistence.Repositories.TareaRepository;

@Service
public class TareaServiceImpl implements TareaService {

    private TareaRepository tareaRepository;
    
    public TareaServiceImpl(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    @Override
    public List<Tarea> deleteTareaByUsuario(Integer id) {
        
        List<Tarea> tareas = tareaRepository.findAllByUsuario_id(id);

        for(Tarea t:tareas){
            tareaRepository.delete(t);
        }

        return tareas;
    }

}
