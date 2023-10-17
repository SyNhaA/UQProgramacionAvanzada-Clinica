package co.edu.uniquindio.uniclinic.dto.autenticacion;

public record MensajeDTO<T>(
        boolean error,
        T respuesta
) {
}
