package MicroS.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import MicroS.app.Persistence.Entities.Tipo;
import MicroS.app.Services.TipoService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/tipos")
public class TipoRestController {

    private final TipoService tipoService;

    public TipoRestController(TipoService tipoService) {
        this.tipoService = tipoService;
    }

    @GetMapping
    private ResponseEntity<?> getTipos(){

        List<Tipo> tipos=tipoService.getTipos();
        return ResponseEntity.ok(tipos);
    }
    
    @PostMapping
    public ResponseEntity<?> addTipo(@RequestBody Tipo tipo){
        Tipo t=tipoService.addTipo(tipo);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteTipo(@PathVariable Integer id){
    
        Tipo t=tipoService.deleteTipo(id);
        return ResponseEntity.ok(t);
    }
 
}
 