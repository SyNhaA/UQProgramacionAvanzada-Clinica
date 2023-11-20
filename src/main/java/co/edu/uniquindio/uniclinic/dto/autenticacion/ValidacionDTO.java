package co.edu.uniquindio.uniclinic.dto.autenticacion;

import jakarta.validation.constraints.NotBlank;

public record ValidacionDTO(
        @NotBlank
        String field,
        @NotBlank
        String defaultMessage
) {
}
