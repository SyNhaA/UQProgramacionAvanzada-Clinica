package co.edu.uniquindio.uniclinic.dto.autenticacion;

import jakarta.validation.constraints.NotBlank;

public record TokenDTO(
        @NotBlank
        String token
) {
}
