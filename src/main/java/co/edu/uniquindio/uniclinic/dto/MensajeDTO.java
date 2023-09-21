package co.edu.uniquindio.uniclinic.dto;

import java.time.LocalDateTime;

public record MensajeDTO(
        LocalDateTime fecha,
        String mensaje
) {
}
