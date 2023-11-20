package co.edu.uniquindio.uniclinic.controladores;

import co.edu.uniquindio.uniclinic.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/pacientes")
@SecurityRequirement(name = "bearerAuth")
public class PacienteController {

    private final PacienteServicio pacienteServicio;

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<MensajeDTO<InfoPacienteDTO>> verDetallePaciente(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetallePaciente(codigo)));
    }

    @PutMapping("/editar-perfil")
    public int editarPerfil(@Valid @RequestBody InfoPacienteDTO pacienteDTO) throws Exception {
        return pacienteServicio.editarPerfil(pacienteDTO);
    }

    @DeleteMapping("/eliminar/{codigo}")
    public void eliminarCuenta(@PathVariable int codigo) throws Exception {
        pacienteServicio.eliminarCuenta(codigo);
    }

    @PostMapping("/agendarcita")
    public ResponseEntity<MensajeDTO<String>> agendarCita(@Valid @RequestBody RegistroCitaDTO citaDTO) throws Exception {
        pacienteServicio.agendarCita(citaDTO);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita agendada correctamente"));
    }

    @GetMapping("/listarcitascompletadas/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarCitasCompletadas(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.listarCitasCompletadasPaciente(codigo)));
    }

    @GetMapping("/filtrarcitas")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> filtrarcitas(@Valid @RequestBody FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.filtrarCitas(filtroBusquedaCitaDTO)));
    }

    @GetMapping("/detallecita/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleAtencionMedicaDTO>> detalleCita(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleCita(codigo)));
    }

    @GetMapping("/detallecitarecetamedica/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleRecetaDTO>> detalleRecetaMedica(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleRecetaMedica(codigo)));
    }

    @GetMapping("/detalleincapacidad/{codigo}")
    public ResponseEntity<MensajeDTO<DetalleIncapacidadDTO>> detalleIncapacidad(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, pacienteServicio.verDetalleIncapacidad(codigo)));
    }
}
