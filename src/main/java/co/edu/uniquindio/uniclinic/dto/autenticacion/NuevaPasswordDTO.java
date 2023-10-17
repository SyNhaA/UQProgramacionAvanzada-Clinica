package co.edu.uniquindio.uniclinic.dto.autenticacion;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record NuevaPasswordDTO(
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        @Length(max = 80, message = "La contraseña no puede superar los 80 caracteres")
        String passwordNueva
) {
}
