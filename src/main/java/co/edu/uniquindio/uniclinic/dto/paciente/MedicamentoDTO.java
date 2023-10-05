package co.edu.uniquindio.uniclinic.dto.paciente;

public record MedicamentoDTO(
        String nombre,
        int cantidad,
        String viaAdministracion,
        String dosis
) {
}
