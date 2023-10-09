package co.edu.uniquindio.uniclinic.dto.admin;

import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record RegistroMedicoDTO(
        @NotBlank(message = "El nombre es obligatorio")
        @Length(max = 100, message = "El nombre no puede superar los 100 caracteres")
        String nombre,
        @NotBlank(message = "El correo es obligatorio")
        @Length(max = 80, message = "El correo no puede superar los 80 caracteres")
        String correo,
        @NotBlank(message = "La cédula es obligatoria")
        @Length(max = 10, message = "La cédula no puede superar los 10 caracteres")
        String cedula,
        @NotBlank(message = "El teléfono es obligatorio")
        @Length(max = 10, message = "El teléfono no puede superar los 10 caracteres")
        String telefono,
        @NotNull(message = "Por favor, seleccione una ciudad")
        Ciudad ciudad,
        @NotNull(message = "Por favor, seleccione una especialidad")
        Especialidad especialidad,
        @NotBlank(message = "La contraseña es obligatoria")
        @Length(max = 80, message = "La contraseña no puede superar los 80 caracteres")
        String contrasenia,
        @NotBlank(message = "La foto es obligatoria")
        @Length(max = 500, message = "La url de la foto no puede superar los 500 caracteres")
        String urlFoto,
        @NotEmpty(message = "Por favor, ingrese los horarios de atención")
        List<HorarioDTO> horarios
) {
}
