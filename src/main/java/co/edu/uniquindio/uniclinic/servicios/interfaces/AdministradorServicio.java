package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.admin.*;
import co.edu.uniquindio.uniclinic.dto.paciente.DetallePQRSDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemPQRSDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroRespuestaDTO;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(RegistroMedicoDTO medico) throws Exception;

    int actualizarMedico(DetalleMedicoDTO medico) throws Exception;

    void eliminarMedico(int codigo) throws Exception;

    List<ItemMedicoDTO> listarMedicos() throws Exception;

    DetalleMedicoDTO obtenerMedico(int codigo) throws Exception;

    List<ItemCitaDTO> listarCitas() throws Exception;

}
