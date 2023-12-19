package cl.ufro.endopdf.services;

import cl.ufro.endopdf.config.JwtAuthenticationResponse;
import cl.ufro.endopdf.config.request.SignInRequest;
import cl.ufro.endopdf.config.request.SignUpRequest;
import cl.ufro.endopdf.config.request.UserNotFoundException;
import cl.ufro.endopdf.models.Medico;
import cl.ufro.endopdf.repositories.MedicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicoService {
    private final MedicoRepository medicoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserDetailsService userDetailsService() {
        return username -> {
            try {
                return medicoRepository.findByEmail(username)
                        .orElseThrow(() -> new UserNotFoundException("User not found"));
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public JwtAuthenticationResponse signup(SignUpRequest request) throws UserNotFoundException {

        if(medicoRepository.existsByEmail(request.getEmail())){
            throw new UserNotFoundException ("Email is already registered");
        }

        var user = Medico.builder()
                .email(request.getEmail())

                .contrasena(passwordEncoder.encode(request.getPassword())).build();
        medicoRepository.save(user);

        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = medicoRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
