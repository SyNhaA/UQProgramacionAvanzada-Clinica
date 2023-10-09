package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.pqrs.*;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;

import java.util.List;

public interface PQRSServicio {

    // ADMINISTRADOR
    List<ItemPQRSAdminDTO> listarPQRS() throws Exception;

    void cambiarEstadoPQRS(int codigoPQRS, EstadoPQRS estadoPQRS) throws Exception;

    // PACIENTE
    List<ItemPQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception;

    // AMBOS
    DetallePQRSDTO verDetallePQRS(int codigoPQRS) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

}
