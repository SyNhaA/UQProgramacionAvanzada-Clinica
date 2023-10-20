package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record FiltroBusquedaCitaDTO(
        int codigoPaciente,
        String nombreMedico,
        LocalDateTime fechaCita
) {
}
