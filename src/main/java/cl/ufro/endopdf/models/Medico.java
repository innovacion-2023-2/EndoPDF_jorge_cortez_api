package cl.ufro.endopdf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Medico{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String contrasena;
    private String email;
}
