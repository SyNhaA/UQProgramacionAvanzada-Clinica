package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.admin.InfoMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.ItemConsultaDTO;
import co.edu.uniquindio.uniclinic.dto.admin.ItemMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.admin.RegistroMedicoDTO;
import co.edu.uniquindio.uniclinic.dto.medico.HorarioDTO;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;
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
    public void crearMedicoTest() throws ResourceAlreadyExistsException {
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

        int nuevo = administradorServicio.crearMedico(medicoDTO);

        Assertions.assertNotEquals(0, nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarMedicoTest() throws ResourceNotFoundException, ResourceAlreadyExistsException {
        InfoMedicoDTO guardado = administradorServicio.obtenerMedico(11);

        InfoMedicoDTO modificado = new InfoMedicoDTO(
                guardado.codigo(),
                guardado.nombre(),
                "andres@email.com",
                guardado.cedula(),
                guardado.telefono(),
                guardado.ciudad(),
                guardado.especialidad(),
                guardado.urlFoto(),
                guardado.horarios()
        );

        administradorServicio.actualizarMedico(modificado);

        InfoMedicoDTO actualizado = administradorServicio.obtenerMedico(11);

        Assertions.assertNotEquals(guardado.correo(), actualizado.correo());
        Assertions.assertEquals(modificado.correo(), actualizado.correo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarMedicoTest() throws ResourceNotFoundException {
        administradorServicio.eliminarMedico(12);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            administradorServicio.obtenerMedico(12);
        });
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarMedicosTest() throws ResourceNotFoundException {
        List<ItemMedicoDTO> medicos = administradorServicio.listarMedicos();
        medicos.forEach(System.out::println);

        Assertions.assertEquals(10, medicos.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerMedicoTest() throws ResourceNotFoundException {
        InfoMedicoDTO medico = administradorServicio.obtenerMedico(11);
        System.out.println(medico);

        Assertions.assertEquals(11, medico.codigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarConsultasMedicoTest() throws ResourceNotFoundException {
        List<ItemConsultaDTO> consultas = administradorServicio.listarConsultasMedico(13);
        consultas.forEach(System.out::println);

        Assertions.assertEquals(2, consultas.size());
    }

}
