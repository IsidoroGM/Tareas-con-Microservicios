package MicroS.app.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import MicroS.app.Persistence.Entities.Tipo;

public interface TipoRepository extends JpaRepository<Tipo, Integer> {

    //Creamos el metodo busque filas a partir del nombre de tareas.

    public Tipo findByNombre (String nombre);

}
