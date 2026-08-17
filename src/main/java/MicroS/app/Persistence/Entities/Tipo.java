package MicroS.app.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="tipo")
public class Tipo {

    @Id
    //Se va a generar automaticamente, tomando como valor el siguiente al ya existente. 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String nombre;

    //Constructor sin parámetros
    public Tipo() {
    }

    //Constructor con parámetros
    public Tipo(int id, String nombre) {
        Id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    
    

    

}
