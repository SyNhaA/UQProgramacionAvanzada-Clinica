package co.edu.uniquindio.uniclinic.dto.pqrs;

import java.time.LocalDateTime;

public record RespuestaDTO(
        LocalDateTime fecha,
        String mensaje
) {
}
