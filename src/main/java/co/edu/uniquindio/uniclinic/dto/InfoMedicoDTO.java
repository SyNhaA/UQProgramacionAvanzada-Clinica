package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.util.List;

public record InfoMedicoDTO(
        int codigo,
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
