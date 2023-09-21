package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record InfoPQRSDTO(
        int codigo,
        LocalDateTime fecha,
        int codigoCita,
        String nombrePaciente,
        String motivo,
        EstadoPQRS estado,
        List<MensajeDTO> mensajes
) {
}
