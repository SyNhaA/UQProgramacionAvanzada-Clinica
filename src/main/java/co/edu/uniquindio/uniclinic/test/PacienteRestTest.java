package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.autenticacion.TokenDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.InfoPacienteDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;
import co.edu.uniquindio.uniclinic.servicios.implementaciones.AutenticacionServicioImpl;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PacienteRestTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AutenticacionServicioImpl autenticacionServicioImpl;

    @Test
    @Transactional
    public void registrarTest() throws Exception {
        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                "juan",
                "juan@gmail.com",
                "11",
                "3231387",
                Ciudad.ARMENIA,
                EPS.NUEVA_EPS,
                TipoSangre.A_POSITIVO,
                "añañai",
                "foto.com",
                LocalDate.of(1990, 10, 7),
                "El polvo y el polen me hacen estornudar"
        );

        mockMvc.perform(post("/api/auth/registrarse")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(pacienteDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void loginTest() throws Exception {
        LoginDTO loginUser = new LoginDTO("pepito@email.com", "1234");
        mockMvc.perform(post("/api/auth/login")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(loginUser)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void verDetallePaciente() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/pacientes/detalle/{codigo}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void editarPerfil() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        InfoPacienteDTO modificado = new InfoPacienteDTO(
                1,
                "Sebastian",
                "test@gmail.com",
                "1123",
                "13331872",
                Ciudad.ARMENIA,
                EPS.NUEVA_EPS,
                TipoSangre.A_POSITIVO,
                "foto.com",
                LocalDate.of(1990, 10, 7),
                "alegrias no"
        );

        mockMvc.perform(put("/api/pacientes/editar-perfil")
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(modificado)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void eliminarCuenta() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(delete("/api/pacientes/eliminar/{codigo}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void detalleCitaTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/pacientes/detallecita/{codigo}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void detalleRecetaMedicaTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/pacientes/detallecitarecetamedica/{codigo}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void detalleIncapacidadTest() throws Exception {
        TokenDTO tokenCompleto = (autenticacionServicioImpl.login(new LoginDTO(
                "pepito@email.com",
                "1234"
        )));

        String token = tokenCompleto.token();

        mockMvc.perform(get("/api/pacientes/detalleincapacidad/{codigo}", 1)
                        .header("Authorization", "Bearer " + token)
                        .contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }
}
