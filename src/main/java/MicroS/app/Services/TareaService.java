package MicroS.app.Services;

import java.time.LocalDate;
import java.util.List;

import MicroS.app.DTO.InfoTareaResponse;
import MicroS.app.Persistence.Entities.Tarea;

public interface TareaService {

    public List<Tarea> getTareas(String username);
    public Tarea addTarea(String username, String tipo, Tarea tarea);

    public Tarea deleteTarea(Integer id);

    public List<Tarea> getTareas(String username, LocalDate fecha);

    public List<Tarea> getTareas(String username, boolean finalizada);


    public List<Tarea> deleteTareaByUsuario(Integer id);
    public List<Tarea> deleteTareabyTipoid(Integer id);

    public List <InfoTareaResponse> getInfoTareas();

}
