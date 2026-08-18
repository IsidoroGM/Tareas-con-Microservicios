package MicroS.app.Persistence.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import MicroS.app.Persistence.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

    Usuario findByUsername(String username); 

}
