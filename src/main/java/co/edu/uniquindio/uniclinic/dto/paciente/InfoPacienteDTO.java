package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record InfoPacienteDTO(

        @Positive(message = "El código debe ser mayor a cero")
        int codigo,
        @NotBlank(message = "El nombre es obligatorio")
        @Length(max = 100, message = "El nombre no puede superar los 100 caracteres")
        String nombre,
        @NotBlank(message = "El correo es obligatorio")
        @Length(max = 80, message = "El correo no puede superar los 80 caracteres")
        @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
                flags = Pattern.Flag.CASE_INSENSITIVE, message = "El correo no es válido")
        String correo,
        @NotBlank(message = "La cédula es obligatoria")
        @Length(max = 10, message = "La cédula no puede superar los 10 caracteres")
        String cedula,
        @NotBlank(message = "El teléfono es obligatorio")
        @Length(max = 10, message = "El teléfono no puede superar los 10 caracteres")
        String telefono,
        @NotNull(message = "Por favor, seleccione una ciudad")
        Ciudad ciudad,
        @NotNull(message = "Por favor, seleccione una EPS")
        EPS eps,
        @NotNull(message = "Por favor, seleccione un tipo de sangre")
        TipoSangre tipoSangre,
        @NotBlank(message = "La foto es obligatoria")
        @Length(max = 500, message = "La url de la foto no puede superar los 500 caracteres")
        String urlFoto,
        @NotNull(message = "Por favor, ingrese la fecha de nacimiento")
        @Past(message = "La fecha de nacimiento debe ser anterior a la fecha actual")
        LocalDate fechaNacimiento,
        @NotBlank(message = "Las alergias son obligatorias")
        @Length(max = 500, message = "Las alergias no pueden superar los 500 caracteres")
        String alergias
) {
}
