package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

public record RegistroCitaDTO(
        int codigoPaciente,
        @NotNull(message = "Por favor, seleccione una especialidad")
        Especialidad especialidad,
        @NotNull(message = "Por favor, seleccione un médico")
        String nombreMedico,
        @NotNull(message = "Por favor, seleccione una fecha y hora")
        LocalDateTime fechaCita,
        @NotBlank(message = "El motivo es obligatorio")
        @Length(max = 250, message = "El motivo no puede superar los 250 caracteres")
        String motivo
) {
}
