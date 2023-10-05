package co.edu.uniquindio.uniclinic.dto.medico;

import co.edu.uniquindio.uniclinic.dto.paciente.MedicamentoDTO;

import java.time.LocalDateTime;
import java.util.List;

public record RegistroAtencionDTO(
        String notasMedicas,
        String diagnostico,
        String tratamiento,
        String descripcionReceta,
        List<MedicamentoDTO> medicamentos,
        String motivoIncapacidad,
        LocalDateTime fechaInicioIncapacidad,
        LocalDateTime fechaFinIncapacidad
) {
}
