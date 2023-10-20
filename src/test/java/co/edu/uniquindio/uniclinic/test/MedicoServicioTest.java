package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.ItemCitaDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.MedicamentoDTO;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.ArrayList;
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
        List<ItemConsultaDTO> citasPendientes = medicoServicio.listarCitasPendientes(15);
        System.out.println("Resultado" + citasPendientes.size());
        Assertions.assertEquals(0, citasPendientes.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void atenderCita() throws Exception {
        List<MedicamentoDTO> medicamentos = new ArrayList<>();
        medicamentos.add(medicoServicio.obtenerMedicamento(1));
        medicamentos.add(medicoServicio.obtenerMedicamento(3));
        medicamentos.add(medicoServicio.obtenerMedicamento(5));

        LocalDate today = LocalDate.now();
        LocalDate incapacidad = today.plusDays(7);

        RegistroAtencionDTO registroAtencionDTO = new RegistroAtencionDTO(
                "Nota Medica: El paciente esta muy bien",
                "Diagnostico: Paciente vino por control rutinario, se encuentra en escelente estado",
                "Tratamiento: vitamica c cada 8 horas",
                "Cada 8 horas",
                medicamentos,
                "Incapacidad 7 dias, por buena persona",
                LocalDate.now(),
                incapacidad
        );

        medicoServicio.atenderCita(registroAtencionDTO, 11);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarHistorialAtencionesPaciente() throws Exception {
        List<ItemCitaDTO> listaHistorialAtencionesPaciente = medicoServicio.listarHistorialAtencionesPaciente(2);
        Assertions.assertEquals(1, listaHistorialAtencionesPaciente.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibre() throws Exception {
        LocalDate dia = LocalDate.now();
        LocalDate fechaFutura = dia.plusDays(7);

        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                fechaFutura
        );

        int ward = medicoServicio.agendarDiaLibre(diaLibreDTO, 15);
        Assertions.assertEquals(1, ward);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasRealizadasMedico() throws Exception {
        List<ItemConsultaDTO> citas = medicoServicio.listarCitasRealizadasMedico(13);
        Assertions.assertEquals(3, citas.size());
    }

}
