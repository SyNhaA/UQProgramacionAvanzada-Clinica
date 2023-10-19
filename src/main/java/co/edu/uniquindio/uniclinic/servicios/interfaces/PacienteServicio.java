package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO pacienteDTO) throws Exception;

    int editarPerfil(InfoPacienteDTO infoPacienteDTO) throws Exception;

    void eliminarCuenta(int codigo) throws Exception;

    void enviarLinkRecuperacion(String correo) throws Exception;

    int cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

    InfoPacienteDTO verDetallePaciente(int codigo) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitas(FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;

    DetalleRecetaDTO verDetalleRecetaMedica(int codigoReceta) throws Exception;

    DetalleIncapacidadDTO verDetalleIncapacidad(int codigoIncapacidad) throws Exception;

}
