package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoCita;

import java.time.LocalDateTime;

public record DetalleAtencionMedicaDTO(
        int codigo,
        String nombreMedico,
        Especialidad especialidad,
        LocalDateTime fecha,
        String motivo,
        EstadoCita estado,
        String notasMedicas,
        String diagnostico,
        String tratamiento
) {
}
