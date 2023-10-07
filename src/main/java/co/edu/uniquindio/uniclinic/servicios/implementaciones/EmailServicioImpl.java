package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.dto.email.EmailDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.EmailServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    @Override
    public String enviarCorreo(EmailDTO emailDTO) throws Exception {
        return null;
    }

}
