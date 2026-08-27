package MicroS.app.Controllers;

import org.springframework.web.bind.annotation.RestController;

import MicroS.app.DTO.LoginRequest;
import MicroS.app.DTO.TokenResponse;
import MicroS.app.Persistence.Entities.Usuario;
import MicroS.app.Services.AuthService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final AuthService authService;

    public AuthRestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody Usuario usuario){
        TokenResponse token = authService.register(usuario);
        return ResponseEntity.ok(token);
        
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){
        TokenResponse token = authService.login(request);
        return ResponseEntity.ok(token);
    }
    
    @PostMapping("/refresh")
    public ResponseEntity<?> refhres(@RequestHeader(HttpHeaders.AUTHORIZATION)String authHeader){
        //RequestHeader lee el Header de la consulta (postman)
        //HttpHeaders lee la consulta con key "AUTHORIZATION"
        //A dicha consulta le damos el nombre String authHeader

        TokenResponse token = authService.refresh(authHeader);
        return ResponseEntity.ok(token);
    }
    
    

}
