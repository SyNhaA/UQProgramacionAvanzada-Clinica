package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.autenticacion.LoginDTO;
import co.edu.uniquindio.uniclinic.dto.paciente.RegistroPacienteDTO;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AutenticacionRestTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    @Transactional
    public void registrarPacienteTest() throws Exception {
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


}
