package cl.ufro.endopdf.controllers;

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
    public Medico signup(@RequestBody SignUpRequest request) {
        return medicoService.saveMedico(request);
    }
}
