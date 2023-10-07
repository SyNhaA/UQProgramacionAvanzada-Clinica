package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.pqrs.*;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PQRSServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PQRSServicioImpl implements PQRSServicio {

    @Override
    public List<ItemPQRSAdminDTO> listarPQRS() throws Exception {
        return null;
    }

    @Override
    public List<ItemPQRSPacienteDTO> listarPQRSPaciente(int codigoPaciente) throws Exception {
        return null;
    }

    @Override
    public int crearPQRS(RegistroPQRSDTO registroPQRSDTO) throws Exception {
        return 0;
    }

    @Override
    public DetallePQRSDTO verDetallePQRS(int codigoPQRS) throws Exception {
        return null;
    }

    @Override
    public int responderPQRS(RegistroRespuestaDTO registroRespuestaDTO) throws Exception {
        return 0;
    }

}
