package MicroS.app.Persistence.Repositories;

import MicroS.app.Persistence.Entities.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    

}
