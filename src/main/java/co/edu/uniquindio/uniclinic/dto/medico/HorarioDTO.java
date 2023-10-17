package co.edu.uniquindio.uniclinic.dto.medico;

import co.edu.uniquindio.uniclinic.modelo.enums.Dia;
import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;

public record HorarioDTO(
        @NotNull(message = "Por favor, seleccione un día")
        Dia dia,
        @NotNull(message = "Por favor, ingrese una hora de inicio")
        LocalTime horaInicio,
        @NotNull(message = "Por favor, ingrese una hora de salida")
        LocalTime horaFin
) {
}
