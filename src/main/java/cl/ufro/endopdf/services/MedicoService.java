package cl.ufro.endopdf.services;

import cl.ufro.endopdf.config.request.SignUpRequest;
import cl.ufro.endopdf.models.Medico;
import cl.ufro.endopdf.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;

    public Medico saveMedico(SignUpRequest signUpRequest){
        Medico medico = Medico.builder()
                .email(signUpRequest.getEmail())
                .contrasena(signUpRequest.getPassword()).build();
        return medicoRepository.save(medico);
    }
}
