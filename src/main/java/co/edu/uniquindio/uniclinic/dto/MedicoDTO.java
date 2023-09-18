package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.util.List;

public record MedicoDTO(
        String cedula,
        String nombre,
        String telefono,
        Ciudad ciudad,
        String correo,
        String contrasenia,
        Especialidad especialidad,
        List<HorarioDTO> horarioDTO
) {
}
