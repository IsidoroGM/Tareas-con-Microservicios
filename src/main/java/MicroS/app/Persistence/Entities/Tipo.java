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
    private Integer id;
    private String nombre;

    //Constructor sin parámetros
    public Tipo() {
    }

    //Constructor con parámetros
    public Tipo(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
