package MicroS.app.Persistence.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import MicroS.app.Persistence.Entities.Tarea;



public interface TareaRepository extends JpaRepository<Tarea, Integer>{

    public List<Tarea> findAllByUsuario_id(Integer id);

}
