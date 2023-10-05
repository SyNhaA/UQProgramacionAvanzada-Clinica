package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.NuevaPasswordDTO;

public interface AutenticacionServicio {

    String login(LoginDTO loginDTO) throws Exception;

    void enviarLinkRecuperacion(String correo) throws Exception;

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

}
