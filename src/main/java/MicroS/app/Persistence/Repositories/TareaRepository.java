package MicroS.app.Persistence.Repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import MicroS.app.DTO.InfoTareaResponse;
import MicroS.app.Persistence.Entities.Tarea;



public interface TareaRepository extends JpaRepository<Tarea, Integer>{

    public List<Tarea> findAllByUsuario_id(Integer id);

    public List<Tarea> findAllByTipo_id(Integer id);

    public List<Tarea> findAllByFechaAndUsuario_Id(LocalDate fecha, Integer id);

    public List<Tarea> findByRealizadaAndUsuario_Id(boolean finalizada, Integer id);

    @Query(value = "select t.titulo,t.resumen,t.realizada,t.fecha,tip.nombre,u.username from tarea t left join usuario u on t.usuario_id=u.id left join tipo tip on t.tipo_id=tip.id" , nativeQuery = true)
    public List<InfoTareaResponse> getInfoTarea();   
}
