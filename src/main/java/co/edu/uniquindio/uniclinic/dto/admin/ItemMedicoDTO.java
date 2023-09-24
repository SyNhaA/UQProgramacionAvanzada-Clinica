package co.edu.uniquindio.uniclinic.dto.admin;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

public record ItemMedicoDTO(
        int codigo,
        String cedula,
        String nombre,
        String urlFoto,
        Especialidad especialidad
) {
}
