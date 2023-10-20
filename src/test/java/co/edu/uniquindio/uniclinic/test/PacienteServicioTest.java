package co.edu.uniquindio.uniclinic.test;

import co.edu.uniquindio.uniclinic.dto.paciente.*;
import co.edu.uniquindio.uniclinic.excepciones.ResourceAlreadyExistsException;
import co.edu.uniquindio.uniclinic.excepciones.ResourceNotFoundException;
import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;
import co.edu.uniquindio.uniclinic.servicios.interfaces.PacienteServicio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Transactional
public class PacienteServicioTest {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrarseTest() throws ResourceAlreadyExistsException {
        RegistroPacienteDTO pacienteDTO = new RegistroPacienteDTO(
                "Mario Tabares",
                "mariot@gmail.com",
                "1193072369",
                "3225903978",
                Ciudad.ARMENIA,
                EPS.SALUD_TOTAL,
                TipoSangre.O_POSITIVO,
                "mariot123",
                "foto1.jpg",
                LocalDate.of(1997, 3, 23),
                "Alergico a la penicilina"
        );

        int nuevo = pacienteServicio.registrarse(pacienteDTO);

        Assertions.assertNotEquals(0, nuevo);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void editarPerfilTest() throws ResourceAlreadyExistsException, ResourceNotFoundException {
        InfoPacienteDTO guardado = pacienteServicio.verDetallePaciente(4);

        InfoPacienteDTO modificado = new InfoPacienteDTO(
                guardado.codigo(),
                guardado.nombre(),
                guardado.correo(),
                guardado.cedula(),
                guardado.telefono(),
                guardado.ciudad(),
                EPS.COMFENALCO,
                guardado.tipoSangre(),
                guardado.urlFoto(),
                guardado.fechaNacimiento(),
                guardado.alergias()
        );

        pacienteServicio.editarPerfil(modificado);

        InfoPacienteDTO actualizado = pacienteServicio.verDetallePaciente(4);

        Assertions.assertNotEquals(guardado.eps(), actualizado.eps());
        Assertions.assertEquals(modificado.eps(), actualizado.eps());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCuentaTest() throws ResourceNotFoundException {
        pacienteServicio.eliminarCuenta(4);

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            pacienteServicio.verDetallePaciente(4);
        });
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetallePacienteTest() throws ResourceNotFoundException {
        InfoPacienteDTO paciente = pacienteServicio.verDetallePaciente(4);
        System.out.println(paciente);

        Assertions.assertEquals(4, paciente.codigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarCitasCompletadasPacienteTest() throws ResourceNotFoundException {
        List<ItemCitaDTO> citas = pacienteServicio.listarCitasCompletadasPaciente(6);
        citas.forEach(System.out::println);

        Assertions.assertEquals(2, citas.size());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleCitaTest() throws ResourceNotFoundException {
        DetalleAtencionMedicaDTO cita = pacienteServicio.verDetalleCita(1);
        System.out.println(cita);

        Assertions.assertEquals(4, cita.codigo());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleRecetaMedicaTest() throws ResourceNotFoundException {
        DetalleRecetaDTO receta = pacienteServicio.verDetalleRecetaMedica(1);
        System.out.println(receta);

        Assertions.assertEquals(3, receta.codigoCita());
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void verDetalleIncapacidadTest() throws ResourceNotFoundException {
        DetalleIncapacidadDTO incapacidad = pacienteServicio.verDetalleIncapacidad(1);
        System.out.println(incapacidad);

        Assertions.assertEquals(3, incapacidad.codigoCita());
    }

}
