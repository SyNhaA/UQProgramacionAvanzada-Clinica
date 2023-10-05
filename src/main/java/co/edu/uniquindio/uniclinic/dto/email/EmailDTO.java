package co.edu.uniquindio.uniclinic.dto.email;

public record EmailDTO(
        String remitente,
        String destinatario,
        String asunto,
        String mensaje
) {
}
