package co.edu.uniquindio.uniclinic.dto.paciente;

public record EmailDTO(
        String remitente,
        String destinatario,
        String asunto,
        String mensaje
) {
}
