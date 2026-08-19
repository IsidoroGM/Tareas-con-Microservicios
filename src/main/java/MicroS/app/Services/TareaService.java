package MicroS.app.Services;

import java.util.List;

import MicroS.app.Persistence.Entities.Tarea;

public interface TareaService {

    public List<Tarea> deleteTareaByUsuario(Integer id);

}
