package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;

public record PQRSDTOAdmin(
        int codigo,
        EstadoPQRS estado,
        LocalDateTime fecha,
        String nombrePaciente
) {
}
