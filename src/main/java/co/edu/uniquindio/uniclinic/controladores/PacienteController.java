package co.edu.uniquindio.uniclinic.controladores;

import co.edu.uniquindio.uniclinic.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.InfoPacienteDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @PostMapping("/registrarse")
    public ResponseEntity<MensajeDTO<String>> registrarse(@Valid @RequestBody RegistroPacienteDTO pacienteDTO) throws Exception{
        pacienteServicio.registrarse(pacienteDTO);
        return ResponseEntity.ok().body( new MensajeDTO<>(false, "Paciente registrado correctamente"));
    }

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<MensajeDTO<InfoPacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception{
        this.codigo = codigo;
        return ResponseEntity.ok().body( new MensajeDTO<>(false, pacienteServicio.verDetallePaciente(codigo)) );
    }

    @PutMapping("/editar-perfil")
    public int editarPerfil(@Valid @RequestBody InfoPacienteDTO pacienteDTO) throws Exception{
        return pacienteServicio.editarPerfil(pacienteDTO);
    }
    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCuenta(@PathVariable int codigo) throws Exception{
        pacienteServicio.eliminarCuenta(codigo);
    }
    @GetMapping("/detalle/{codigo}")
    public InfoPacienteDTO verDetallePaciente(@PathVariable int codigo) throws Exception{
        return pacienteServicio.verDetallePaciente(codigo);
    }

}
