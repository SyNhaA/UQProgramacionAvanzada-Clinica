package co.edu.uniquindio.uniclinic.dto.medico;

import java.time.LocalDate;
import java.time.LocalTime;

public record HorarioDTO(
        LocalDate dia,
        LocalTime horaInicio,
        LocalTime horaFin
) {
}
