package co.edu.uniquindio.uniclinic.dto.paciente;

import java.util.List;

public record DetalleRecetaDTO(
        int codigoCita,
        String descripcion,
        List<MedicamentoDTO> medicamentos
) {
}
