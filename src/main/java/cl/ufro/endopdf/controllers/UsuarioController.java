package cl.ufro.endopdf.controllers;

import cl.ufro.endopdf.models.Usuario;
import cl.ufro.endopdf.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;

    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario){
        try{
            Usuario savedUsuario = usuarioService.saveUsuario(usuario);
            return new ResponseEntity<>(savedUsuario, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
