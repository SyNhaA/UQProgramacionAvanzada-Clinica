package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDate;

public record DetalleIncapacidadDTO(
        int codigoCita,
        String diagnostico,
        LocalDate fechaInicio,
        LocalDate fechaFin
) {
}
