package co.edu.uniquindio.uniclinic.dto.pqrs;

import java.time.LocalDateTime;

public record RespuestaDTO(
        int codigoMensaje,
        String correoRemitente,
        LocalDateTime fecha,
        String mensaje
) {
}
