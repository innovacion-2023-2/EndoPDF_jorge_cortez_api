package cl.ufro.endopdf.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@RequiredArgsConstructor
public class Informe {
    @Id
    private Integer id;
    private String nombre;
    private String linkArchivo;
    private String bufferData;
    private String observaciones;
}
