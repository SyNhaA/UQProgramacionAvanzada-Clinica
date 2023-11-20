package co.edu.uniquindio.uniclinic.controladores;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.TokenDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AutenticacionServicio;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@SecurityRequirement(name = "bearerAuth")
@RequiredArgsConstructor
public class AutenticacionController {
    private final AutenticacionServicio autenticacionServicio;
    private final PacienteServicio pacienteServicio;

    @PostMapping("/login")
    public ResponseEntity<MensajeDTO<TokenDTO>> login(@Valid @RequestBody LoginDTO loginDTO)
            throws Exception {
        TokenDTO tokenDTO = autenticacionServicio.login(loginDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, tokenDTO));
    }

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception {
        pacienteServicio.registrarse(pacienteDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }
}