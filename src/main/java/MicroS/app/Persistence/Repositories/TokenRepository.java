package MicroS.app.Persistence.Repositories;

import MicroS.app.Persistence.Entities.Token;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    
    public List<Token> findByExpiredAndRevokedAndUsuario_id(boolean expired, boolean revoked, Integer id);
}
