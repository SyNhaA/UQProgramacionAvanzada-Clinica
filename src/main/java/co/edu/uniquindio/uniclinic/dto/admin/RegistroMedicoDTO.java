package co.edu.uniquindio.uniclinic.dto.admin;

import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.util.List;

public record RegistroMedicoDTO(
        String nombre,
        String correo,
        String cedula,
        String telefono,
        Ciudad ciudad,
        Especialidad especialidad,
        String contrasenia,
        String urlFoto,
        List<HorarioDTO> horarios
) {
}
