package MicroS.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Services.UsuarioService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping("/usuarios")
public class UsuarioRestcontroller {

    
    private UsuarioService usuarioService;

    public UsuarioRestcontroller(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUsuario(){
        List<Usuario> usuarios = usuarioService.getUsuario();
        return ResponseEntity.ok(usuarios);
        
    }
    
    @GetMapping("/{username}")
    public ResponseEntity<?> getUsuario(@PathVariable String username){
        Usuario usuario=usuarioService.getUsuario(username);
        return ResponseEntity.ok(usuario);

    }

    @PutMapping
    public ResponseEntity<?> updateUsuarios(@RequestBody Usuario usuario){
        Usuario usuarioActualizado = usuarioService.updateUsuario(usuario);
        return ResponseEntity.ok(usuarioActualizado);
    }
    

}
