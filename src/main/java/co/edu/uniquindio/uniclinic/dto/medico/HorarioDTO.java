package co.edu.uniquindio.uniclinic.dto.medico;

import co.edu.uniquindio.uniclinic.modelo.enums.Dia;

import java.time.LocalTime;

public record HorarioDTO(
        Dia dia,
        LocalTime horaInicio,
        LocalTime horaFin
) {
}
