package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.time.LocalDateTime;

public record ItemCitaDTO(
        int codigo,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fechaCita,
        String motivo
) {
}
