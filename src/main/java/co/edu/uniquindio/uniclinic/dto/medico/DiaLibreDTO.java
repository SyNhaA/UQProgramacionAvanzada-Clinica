package co.edu.uniquindio.uniclinic.dto.medico;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DiaLibreDTO(
        @NotNull(message = "Por favor, seleccione una fecha")
        @Future(message = "La fecha debe ser posterior a hoy")
        LocalDate fecha
) {
}
