package co.edu.uniquindio.uniclinic.dto;

public record EmailDTO(
        String destinatario,
        String asunto,
        String mensaje
) {
}
