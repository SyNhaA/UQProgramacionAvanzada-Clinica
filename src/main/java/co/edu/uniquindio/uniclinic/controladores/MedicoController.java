package co.edu.uniquindio.uniclinic.controladores;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.MensajeDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.MedicamentoDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/medico")
@SecurityRequirement(name = "bearerAuth")
public class MedicoController {

    private final MedicoServicio medicoServicio;

    @GetMapping("/listarcitaspendientes/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemConsultaDTO>>> listarCitasPendientes(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasPendientes(codigo)));
    }

    @PostMapping("/atenderCita/{codigo}")
    public ResponseEntity<MensajeDTO<String>> atenderCita(@Valid @RequestBody RegistroAtencionDTO registroAtencionDTO, @PathVariable int codigo) throws Exception {
        medicoServicio.atenderCita(registroAtencionDTO, codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Cita atendida correctamente"));
    }

    @GetMapping("/listarHistorialAtencionesPaciente/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemCitaDTO>>> listarHistorialAtencionesPaciente(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarHistorialAtencionesPaciente(codigo)));
    }

    @PostMapping("/agendarDiaLibre/{codigo}")
    public ResponseEntity<MensajeDTO<String>> agendarDiaLibre(@Valid @RequestBody DiaLibreDTO diaLibreDTO, @PathVariable int codigo) throws Exception {
        medicoServicio.agendarDiaLibre(diaLibreDTO, codigo);
        return ResponseEntity.ok().body(new MensajeDTO<>(false, "Dia Agendado Correctamente"));
    }

    @GetMapping("/listarCitasRealizadasMedico/{codigo}")
    public ResponseEntity<MensajeDTO<List<ItemConsultaDTO>>> listarCitasRealizadasMedico(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.listarCitasRealizadasMedico(codigo)));
    }

    @GetMapping("/obtenerMedicamento/{codigo}")
    public ResponseEntity<MensajeDTO<MedicamentoDTO>> obtenerMedicamento(@PathVariable int codigo) throws Exception {
        return ResponseEntity.ok().body(new MensajeDTO<>(false, medicoServicio.obtenerMedicamento(codigo)));
    }
}
