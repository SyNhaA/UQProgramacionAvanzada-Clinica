package co.edu.uniquindio.uniclinic.servicios.interfaces;

import co.edu.uniquindio.uniclinic.dto.EmailDTO;

public interface EmailServicio {

    String enviarCorreo(EmailDTO emailDTO) throws Exception;

}
