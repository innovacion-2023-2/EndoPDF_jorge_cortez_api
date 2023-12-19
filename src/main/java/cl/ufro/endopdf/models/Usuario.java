package cl.ufro.endopdf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Usuario {
    @Id
    private String contrasena;
    private String email;
}
