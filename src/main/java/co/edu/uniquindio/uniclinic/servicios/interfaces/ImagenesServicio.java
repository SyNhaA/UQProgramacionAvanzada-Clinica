package co.edu.uniquindio.uniclinic.servicios.interfaces;

import java.io.File;

public interface ImagenesServicio {

    String subirImagen(File imagen) throws Exception;

    void eliminarImagen(String nombre) throws Exception;

}
