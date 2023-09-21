package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record CitaDTOAdmin(
        int codigo,
        String nombrePaciente,
        String nombreMedico,
        LocalDateTime fechaCita,
        String motivo,
        EstadoCita estado
) {
}
