package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO pacienteDTO) throws ResourceAlreadyExistsException;

    int editarPerfil(InfoPacienteDTO infoPacienteDTO) throws ResourceNotFoundException,
            ResourceAlreadyExistsException;

    void eliminarCuenta(int codigo) throws ResourceNotFoundException;

    InfoPacienteDTO verDetallePaciente(int codigo) throws ResourceNotFoundException;

    int agendarCita(RegistroCitaDTO citaDTO) throws ResourceNotFoundException;

    List<ItemCitaDTO> listarCitasCompletadasPaciente(int codigoPaciente) throws ResourceNotFoundException;

    void filtrarCitas(FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws ResourceNotFoundException;

    DetalleRecetaDTO verDetalleRecetaMedica(int codigoAtencion) throws ResourceNotFoundException;

    DetalleIncapacidadDTO verDetalleIncapacidad(int codigoAtencion) throws ResourceNotFoundException;

}
