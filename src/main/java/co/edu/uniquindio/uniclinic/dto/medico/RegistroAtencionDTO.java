package co.edu.uniquindio.uniclinic.dto.medico;

import co.edu.uniquindio.uniclinic.dto.paciente.MedicamentoDTO;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

public record RegistroAtencionDTO(
        @Length(max = 500, message = "Las notas médicas no pueden superar los 500 caracteres")
        String notasMedicas,
        @NotBlank(message = "El diagnóstico es obligatorio")
        @Length(max = 350, message = "El diagnóstico no puede superar los 350 caracteres")
        String diagnostico,
        @NotBlank(message = "El tratamiento es obligatorio")
        @Length(max = 350, message = "El tratamiento no puede superar los 350 caracteres")
        String tratamiento,
        @Length(max = 250, message = "La descripción de la receta no puede superar los 250 caracteres")
        String descripcionReceta,
        @NotEmpty(message = "Por favor, ingrese los medicamentos")
        List<MedicamentoDTO> medicamentos,
        @NotBlank(message = "El motivo de la incapacidad es obligatorio")
        @Length(max = 200, message = "El motivo de la incapacidad no puede superar los 200 caracteres")
        String motivoIncapacidad,
        @NotNull(message = "Por favor, ingrese la fecha de inicio de la incapacidad")
        @FutureOrPresent(message = "La fecha de inicio de la incapacidad debe ser hoy o en el futuro")
        LocalDate fechaInicioIncapacidad,
        @NotNull(message = "Por favor, ingrese la fecha de fin de la incapacidad")
        @Future(message = "La fecha de fin de la incapacidad debe ser en el futuro")
        LocalDate fechaFinIncapacidad
) {
}
