package co.edu.uniquindio.uniclinic.servicios.implementaciones;

import co.edu.uniquindio.uniclinic.servicios.interfaces.ImagenesServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ImagenesServicioImpl implements ImagenesServicio {

    @Override
    public String subirImagen(File imagen) throws Exception {
        return null;
    }

    @Override
    public void eliminarImagen(String nombre) throws Exception {

    }

}
