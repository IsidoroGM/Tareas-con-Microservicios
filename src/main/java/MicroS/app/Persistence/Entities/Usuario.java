package MicroS.app.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class Usuario {

    @Id
    //Se va a generar automaticamente, tomando como valor el siguiente al ya existente. 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;
    private String nombre;

    //Constructor sin parámetros
    public Usuario(){
        super();
    }

    public Usuario(int id, String username, String password, String nombre) {
        Id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
