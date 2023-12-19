package cl.ufro.endopdf.repositories;

import cl.ufro.endopdf.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
