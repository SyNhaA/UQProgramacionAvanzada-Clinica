package co.edu.uniquindio.uniclinic.dto.admin;

import co.edu.uniquindio.uniclinic.dto.paciente.HorarioDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.util.List;

public record RegistroMedicoDTO(
        String cedula,
        String nombre,
        String telefono,
        Ciudad ciudad,
        Especialidad especialidad,
        String correo,
        String contrasenia,
        List<HorarioDTO> horarios
) {
}
