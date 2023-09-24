package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.paciente.*;

import java.util.List;

public interface PacienteServicio {

    int registrarse(RegistroPacienteDTO registroPacienteDTO) throws Exception;

    int editarPerfil(int codigoPaciente, RegistroPacienteDTO registroPacienteDTO) throws Exception;

    void eliminarCuenta(int codigoPaciente) throws Exception;

    DetallePacienteDTO verDetallePaciente(int codigoPaciente) throws Exception;

    int agendarCita(RegistroCitaDTO registroCitaDTO) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    List<ItemCitaDTO> listarCitasPaciente(int codigoPaciente) throws Exception;

    void filtrarCitas(FiltroBusquedaCitaDTO filtroBusquedaCitaDTO) throws Exception;

    DetalleAtencionMedicaDTO verDetalleCita(int codigoCita) throws Exception;

}
