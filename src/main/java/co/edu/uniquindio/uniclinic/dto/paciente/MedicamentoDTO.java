package co.edu.uniquindio.uniclinic.dto.paciente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record MedicamentoDTO(
        @NotBlank(message = "El nombre es obligatorio")
        @Length(max = 75, message = "El nombre no puede superar los 75 caracteres")
        String nombre,
        @NotBlank(message = "La cantidad es obligatoria")
        @Positive(message = "La cantidad debe ser mayor a cero")
        int cantidad,
        @NotBlank(message = "La vía de administración es obligatoria")
        @Length(max = 40, message = "La vía de administración no puede superar los 40 caracteres")
        String viaAdministracion,
        @NotBlank(message = "La dosis es obligatoria")
        @Length(max = 60, message = "La dosis no puede superar los 60 caracteres")
        String dosis
) {
}
