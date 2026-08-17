package MicroS.app.Persistence.Entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name="")
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String titulo;
    private String resumen;
    private LocalDate fecha;
    private boolean realizada;

    @ManyToOne
    @JoinColumn(name="usuario_Id")
    private Usuario usuario;
    //De esta forma relacionamos la clafe foranea (usuario_id) con la tabla usuario

    @ManyToOne
    @JoinColumn(name="tipo_Id")
    private Tipo tipo;
    //De esta forma relacionamos la clafe foranea (tipo_id) con la tabla tipo

    //constructor sin parámetros
    public Tarea() {
    }

    //Constructor con parámetros, sin Tipo y sin Usuario
    public Tarea(int id, String titulo, String resumen, LocalDate fecha, boolean realizada) {
        Id = id;
        this.titulo = titulo;
        this.resumen = resumen;
        this.fecha = fecha;
        this.realizada = realizada;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    

    

    
}
