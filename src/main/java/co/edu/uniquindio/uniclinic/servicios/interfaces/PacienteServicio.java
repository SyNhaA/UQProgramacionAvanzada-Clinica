package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO pacienteDTO) throws ResourceAlreadyExistsException;

    int editarPerfil(InfoPacienteDTO infoPacienteDTO) throws ResourceNotFoundException,
            ResourceAlreadyExistsException;

    void eliminarCuenta(int codigo) throws ResourceNotFoundException;

    InfoPacienteDTO verDetallePaciente(int codigo) throws ResourceNotFoundException;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    List<ItemCitaDTO> listarCitasCompletadasPaciente(int codigoPaciente) throws ResourceNotFoundException;

    void filtrarCitas(FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;

    DetalleRecetaDTO verDetalleRecetaMedica(int codigoReceta) throws Exception;

    DetalleIncapacidadDTO verDetalleIncapacidad(int codigoIncapacidad) throws Exception;

}
