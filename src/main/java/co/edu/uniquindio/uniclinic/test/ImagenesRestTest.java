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
public class ImagenesRestTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private AutenticacionServicioImpl autenticacionServicioImpl;

    @Test
    @Transactional
    @Sql("classpath:dataset.sql")
    public void subirImagenTest() throws Exception {

    }

}
