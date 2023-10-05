package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDateTime;

public record DetalleIncapacidadDTO(
        int codigoCita,
        String diagnostico,
        LocalDateTime fechaInicio,
        LocalDateTime fechaFin
) {
}
