package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDate;

public record FiltroBusquedaCitaDTO(
        int codigoPaciente,
        String nombreMedico,
        LocalDate fechaCita
) {
}
