package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico and c.estado = 'COMPLETADA'")
    List<Cita> findCitasCompletadasByMedico(int codigoMedico);

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico and c.estado = 'PROGRAMADA'")
    List<Cita> findCitasPendientesByMedico(int codigoMedico);

    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estado = 'COMPLETADA'")
    List<Cita> findCitasCompletadasByPaciente(int codigoPaciente);

    @Query("select count(c) from Cita c where c.paciente.codigo = :codigoPaciente and c.estado = 'PROGRAMADA'")
    int countCitasPendientesByPaciente(int codigoPaciente);

    // Seleccionar las citas completadas de un paciente por el nombre del medico
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estado = 'COMPLETADA' " +
            "and c.medico.nombre like %:nombreMedico%")
    List<Cita> findCitasCompletadasByPacienteAndNombreMedico(int codigoPaciente, String nombreMedico);

    // Seleccionar las citas completadas de un paciente por fecha
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estado = 'COMPLETADA' " +
            "and c.fechaCita = :fechaCita")
    List<Cita> findCitasCompletadasByPacienteAndFechaCita(int codigoPaciente, LocalDateTime fechaCita);

    // Seleccionar las citas completadas de un paciente por el nombre del medico y fecha
    @Query("select c from Cita c where c.paciente.codigo = :codigoPaciente and c.estado = 'COMPLETADA' " +
            "and c.medico.nombre like %:nombreMedico% and c.fechaCita = :fechaCita")
    List<Cita> findCitasCompletadasByPacienteAndNombreMedicoAndFechaCita(int codigoPaciente, String nombreMedico,
                                                                         LocalDateTime fechaCita);

}
