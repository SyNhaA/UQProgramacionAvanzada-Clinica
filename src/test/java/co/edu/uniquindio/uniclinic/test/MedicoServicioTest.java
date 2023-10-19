package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.apache.catalina.filters.ExpiresFilter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class MedicoServicioTest {

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasPendientesTest() throws Exception {
        // Crea un médico de prueba
        List<ItemConsultaDTO> citasPendientes = medicoServicio.listarCitasPendientes(5);
        System.out.println("Resultado" + citasPendientes.size());
        Assertions.assertEquals(5, citasPendientes.size());
    }


    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialAtencionesPaciente() throws Exception {
        List<ItemCitaDTO> listaHistorialAtencionesPaciente = medicoServicio.listarHistorialAtencionesPaciente(2);
        System.out.println(listaHistorialAtencionesPaciente);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibre() throws Exception {
        LocalDate dia = LocalDate.now();
        LocalDate fechaFutura = dia.plusDays(7);

        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                fechaFutura
        );

        int ward = medicoServicio.agendarDiaLibre(diaLibreDTO, 5);
        Assertions.assertEquals(1, ward);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasRealizadasMedico() throws Exception {
        List<ItemConsultaDTO> citas = medicoServicio.listarCitasRealizadasMedico(13);
        Assertions.assertEquals(3, citas.size());
    }

}
