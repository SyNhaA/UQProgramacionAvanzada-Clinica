package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.admin.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;

import java.util.List;

public interface AdministradorServicio {

    int crearMedico(RegistroMedicoDTO medicoDTO) throws ResourceAlreadyExistsException;

    int actualizarMedico(InfoMedicoDTO infoMedicoDTO) throws ResourceNotFoundException,
            ResourceAlreadyExistsException;

    void eliminarMedico(int codigo) throws ResourceNotFoundException;

    List<ItemMedicoDTO> listarMedicos() throws ResourceNotFoundException;

    InfoMedicoDTO obtenerMedico(int codigo) throws ResourceNotFoundException;

    List<ItemConsultaDTO> listarConsultasMedico(int codigoMedico) throws ResourceNotFoundException;

}
