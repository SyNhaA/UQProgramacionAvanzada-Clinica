package co.edu.uniquindio.uniclinic.dto.paciente;

import java.time.LocalDateTime;

public record RespuestaDTO(
        LocalDateTime fecha,
        String mensaje
) {
}
