package MicroS.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import MicroS.app.Persistence.Entities.Tarea;
import MicroS.app.Persistence.Repositories.TareaRepository;
import MicroS.app.Persistence.Repositories.TipoRepository;
import MicroS.app.Persistence.Repositories.UsuarioRepository;
import MicroS.app.Services.TareaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;






@RestController
@RequestMapping("/tareas")
public class TareasRestController {

    private final TareaService tareaService;

    public TareasRestController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getTareas(@PathVariable String username) {
        List<Tarea> tareas = tareaService.getTareas(username);
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/{username}/{tipo}")
    public ResponseEntity<?> addTarea(
            @PathVariable("username") String username,
            @PathVariable("tipo") String tipo,
            @RequestBody Tarea tarea) {
        Tarea t = tareaService.addTarea(username, tipo, tarea);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTarea(@PathVariable Integer id){
        Tarea tarea = tareaService.deleteTarea(id);
        return ResponseEntity.ok(tarea);
    }

    @GetMapping("/{username}/por-fecha")
    public ResponseEntity<?> getTareasPorFecha(
        @PathVariable ("username")String username,
        @RequestParam("fecha")
        @DateTimeFormat (pattern = "yyyy-mm-dd" ) LocalDate fecha){
        
        List<Tarea> tareas = tareaService.getTareas(username,fecha);
        return ResponseEntity.ok(tareas);
        }

        @GetMapping("/{username}/por-realilzadas")
        public String getMethodName(@RequestParam String param) {
            return new String();
        }
        
    
    

}
