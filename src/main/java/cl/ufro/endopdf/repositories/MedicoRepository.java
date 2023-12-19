package cl.ufro.endopdf.repositories;

import cl.ufro.endopdf.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByEmail(String email);

    boolean existsByEmail(String email);
}
