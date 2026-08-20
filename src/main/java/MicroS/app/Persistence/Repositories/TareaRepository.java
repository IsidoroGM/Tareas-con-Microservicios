package MicroS.app.Persistence.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import MicroS.app.Persistence.Entities.Tarea;



public interface TareaRepository extends JpaRepository<Tarea, Integer>{

    public List<Tarea> findAllByUsuario_id(Integer id);

    public List<Tarea> findAllByTipo_id(Integer id);

    public List<Tarea> findAllByFechaAndUsuario_Id(LocalDate fecha, Integer id);
}
