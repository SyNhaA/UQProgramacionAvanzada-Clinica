package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        Especialidad especialidad,
        String nombreMedico,
        LocalDateTime fecha,
        String motivo
) {
}
