package co.edu.uniquindio.uniclinic.dto.pqrs;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record ItemPQRSAdminDTO(
        int codigo,
        String nombrePaciente,
        LocalDateTime fecha,
        EstadoPQRS estado
) {
}
