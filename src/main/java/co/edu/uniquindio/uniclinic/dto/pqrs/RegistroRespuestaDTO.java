package co.edu.uniquindio.uniclinic.dto.pqrs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

public record RegistroRespuestaDTO(
        @NotNull
        @Positive
        int codigoPQRS,
        @NotNull
        @Positive
        int codigoCuenta,
        @Positive
        int codigoMensaje,
        @NotBlank(message = "El mensaje es obligatorio")
        @Length(max = 500, message = "El mensaje no puede superar los 500 caracteres")
        String mensaje
) {
}
