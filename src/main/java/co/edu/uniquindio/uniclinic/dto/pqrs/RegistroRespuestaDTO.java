package co.edu.uniquindio.uniclinic.dto.pqrs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record RegistroRespuestaDTO(
        @Positive
        int codigoPQRS,
        @Positive
        int codigoCuenta,
        @Positive
        int codigoMensaje,
        @NotBlank
        String mensaje
) {
}
