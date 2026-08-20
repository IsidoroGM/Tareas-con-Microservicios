package MicroS.app.Services;

import java.util.List;

import MicroS.app.Persistence.Entities.Tarea;

public interface TareaService {

    public List<Tarea> getTareas(String username);
    public Tarea addTarea(String username, String tipo, Tarea tarea);


    public List<Tarea> deleteTareaByUsuario(Integer id);
    public List<Tarea> deleteTareabyTipoid(Integer id);

}
