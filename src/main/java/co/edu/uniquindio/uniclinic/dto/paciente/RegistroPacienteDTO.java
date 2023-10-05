package co.edu.uniquindio.uniclinic.dto.paciente;

import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;

import java.time.LocalDateTime;
import java.util.List;

public record RegistroPacienteDTO(
        String nombre,
        String correo,
        String cedula,
        String telefono,
        Ciudad ciudad,
        EPS eps,
        TipoSangre tipoSangre,
        String contrasenia,
        String urlFoto,
        LocalDateTime fechaNacimiento,
        List<String> alergias
) {
}
