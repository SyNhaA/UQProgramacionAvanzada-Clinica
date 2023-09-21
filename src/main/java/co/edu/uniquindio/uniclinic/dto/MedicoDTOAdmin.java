package co.edu.uniquindio.uniclinic.dto;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

public record MedicoDTOAdmin(
        int codigo,
        String nombre,
        String urlFoto,
        Especialidad especialidad
) {
}
