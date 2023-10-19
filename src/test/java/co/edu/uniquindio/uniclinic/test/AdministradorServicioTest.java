package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.Dia;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import co.edu.uniquindio.uniclinic.servicios.interfaces.AdministradorServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class AdministradorServicioTest {

    @Autowired
    private AdministradorServicio administradorServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void crearMedicoTest() {
        List<HorarioDTO> horarios = new ArrayList<>();
        horarios.add(new HorarioDTO(Dia.LUNES, LocalTime.of(7, 0, 0),
                LocalTime.of(14, 0, 0)));

        RegistroMedicoDTO medicoDTO = new RegistroMedicoDTO(
                "Carolina Valencia",
                "carov@gmail.com",
                "1234567891",
                "3127890761",
                Ciudad.ARMENIA,
                Especialidad.CARDIOLOGIA,
                "0000",
                "foto1.jpg",
                horarios
        );

        int nuevo = 0;
        try {
            nuevo = administradorServicio.crearMedico(medicoDTO);
        } catch (ResourceAlreadyExistsException e) {
            throw new RuntimeException(e);
        }

        Assertions.assertNotEquals(0, nuevo);
    }

}
