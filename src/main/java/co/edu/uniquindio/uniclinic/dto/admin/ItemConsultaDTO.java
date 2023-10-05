package co.edu.uniquindio.uniclinic.dto.admin;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record ItemConsultaDTO(
        int codigo,
        String nombrePaciente,
        LocalDateTime fechaConsulta,
        String motivo,
        EstadoCita estado
) {
}
