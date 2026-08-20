package MicroS.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import MicroS.app.Persistence.Entities.Tarea;
import MicroS.app.Persistence.Repositories.TareaRepository;
import MicroS.app.Services.TareaService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/Tareas")
public class TareasRestController {

    private TareaService tareaService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getTareas(@PathVariable String username){
        List<Tarea> tareas = tareaService.getTareas(username);
        return ResponseEntity.ok(tareas);
    }

    @PostMapping("/{username}/{tipo}")
    //Declaramos en PathVariable a que parámetro corresponde cada valor
    private ResponseEntity<?> addTarea (@PathVariable("username")String username, @PathVariable("tipo") String tipo, @RequestBody Tarea tarea ){
        Tarea t=tareaService.addTarea(username, tipo, tarea);
    
        return ResponseEntity.ok(t);
    }
    

}
