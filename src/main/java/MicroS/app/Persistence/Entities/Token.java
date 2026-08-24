package MicroS.app.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="token")

public class Token {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer id;
    public String token;
    public boolean revoked;
    public boolean expired;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    public Usuario usuario;

    public Token() {
    }

    public Token(String token, boolean revoked, boolean expired, Usuario usuario) {
        this.token = token;
        this.revoked = revoked;
        this.expired = expired;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

}
