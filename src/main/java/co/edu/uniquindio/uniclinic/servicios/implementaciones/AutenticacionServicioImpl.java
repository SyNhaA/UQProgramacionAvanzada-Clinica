package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AutenticacionServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacionServicioImpl implements AutenticacionServicio {

    @Override
    public String login(LoginDTO loginDTO) throws Exception {
        return null;
    }

    @Override
    public void enviarLinkRecuperacion(String correo) throws Exception {

    }

    @Override
    public void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception {

    }

}
