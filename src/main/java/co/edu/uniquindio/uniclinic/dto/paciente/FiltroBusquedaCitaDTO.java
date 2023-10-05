package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDate;

public record FiltroBusquedaCitaDTO(
        int codigoMedico,
        LocalDate fecha
) {
}
