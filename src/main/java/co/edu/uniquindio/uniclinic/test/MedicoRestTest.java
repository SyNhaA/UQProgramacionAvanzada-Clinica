package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.TokenDTO;
import co.edu.uniquindio.uniclinic.dto.medico.DiaLibreDTO;
import co.edu.uniquindio.uniclinic.dto.medico.RegistroAtencionDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.MedicamentoDTO;
import co.edu.uniquindio.uniclinic.servicios.implementaciones.AutenticacionServicioImpl;
import co.edu.uniquindio.uniclinic.servicios.interfaces.MedicoServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MedicoRestTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AutenticacionServicioImpl autenticacionServicioImpl;

    @Autowired
    private MedicoServicio medicoServicio;

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void listarCitasPendientesTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/medico/listarcitaspendientes/{codigo}", 13)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void atenderCitaTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

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

        mockMvc.perform(post("/api/medico/atenderCita/{codigo}", 11)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(registroAtencionDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void listarHistorialAtencionesPacienteTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/medico/listarHistorialAtencionesPaciente/{codigo}", 9)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void agendarDiaLibreTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        LocalDate dia = LocalDate.now();
        LocalDate fechaFutura = dia.plusDays(7);

        DiaLibreDTO diaLibreDTO = new DiaLibreDTO(
                fechaFutura
        );

        mockMvc.perform(post("/api/medico/agendarDiaLibre/{codigo}", 13)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(diaLibreDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void listarCitasRealizadasMedicoTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/medico/listarCitasRealizadasMedico/{codigo}", 13)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void obtenerMedicamentoTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "carlos1@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/medico/obtenerMedicamento/{codigo}", 8)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

}
