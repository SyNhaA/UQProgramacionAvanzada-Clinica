package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Dia;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AdministradorServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    public void crearMedicoTest(){
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO(Dia.LUNES, LocalTime.of(7, 0, 0),
                LocalTime.of(14, 0, 0)));

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Carolina Valencia",
                "carov@gmail.com",
                "1234567890",
                "3127890761",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGIA,
                "0000",
                "url_foto",
                horarios
        );

        try {
            administradorServicio.crearMedico(medicoDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
