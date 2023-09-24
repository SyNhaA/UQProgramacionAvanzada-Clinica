package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.paciente.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.NuevaPasswordDTO;

public interface AutenticacionServicio {

    void login(LoginDTO loginDTO) throws Exception;

    void enviarLinkRecuperacion(String correo) throws Exception;

    void cambiarPassword(NuevaPasswordDTO nuevaPasswordDTO) throws Exception;

}
