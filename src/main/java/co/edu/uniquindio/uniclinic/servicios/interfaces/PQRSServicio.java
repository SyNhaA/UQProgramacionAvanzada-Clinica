package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.paciente.DetallePQRSDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemPQRSDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroRespuestaDTO;

import java.util.List;

public interface PQRSServicio {

    List<ItemPQRSDTO> listarPQRS() throws Exception;

    List<ItemPQRSDTO> listarPQRSPaciente(int codigoPaciente) throws Exception;

    DetallePQRSDTO verDetallePQRS(int codigoPQRS) throws Exception;

    int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception;

}
