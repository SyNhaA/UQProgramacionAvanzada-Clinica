package co.edu.uniquindio.uniclinic.dto.pqrs;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSPacienteDTO(
        int codigo,
        EstadoPQRS estado,
        String respuesta,
        LocalDateTime fecha
) {
}
