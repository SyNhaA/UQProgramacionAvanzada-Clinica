package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.time.LocalDateTime;
import java.util.List;

public record DetallePQRSDTO(
        int codigo,
        LocalDateTime fecha,
        int codigoCita,
        String nombrePaciente,
        String nombreMedico,
        String motivo,
        EstadoPQRS estado,
        List<RespuestaDTO> mensajes
) {
}
