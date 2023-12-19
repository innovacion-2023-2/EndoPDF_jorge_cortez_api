package cl.ufro.endopdf.controllers;

import cl.ufro.endopdf.config.JwtAuthenticationResponse;
import cl.ufro.endopdf.config.request.SignInRequest;
import cl.ufro.endopdf.config.request.SignUpRequest;
import cl.ufro.endopdf.config.request.UserNotFoundException;
import cl.ufro.endopdf.models.Medico;
import cl.ufro.endopdf.services.MedicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UsuarioController {
    private final MedicoService medicoService;

    @PostMapping("/sign_up")
    public ResponseEntity<String> signup(@RequestBody SignUpRequest request) {
        try {
            JwtAuthenticationResponse response = medicoService.signup(request);
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Correo electrónico ya registrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }

    @PostMapping("/sign_in")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SignInRequest request) {
        return ResponseEntity.ok(medicoService.signin(request));
    }
}
