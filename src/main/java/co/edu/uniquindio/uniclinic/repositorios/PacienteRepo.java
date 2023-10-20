package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.AtencionMedica;
import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepo extends JpaRepository<Paciente, Integer> {

    Paciente findByCedula(String cedula);

    Paciente findByCorreo(String correo);

    Paciente findByCedulaAndCodigoNot(String cedula, int codigo);

    Paciente findByCorreoAndCodigoNot(String correo, int codigo);

    @Query("select p from Paciente p where p.codigo = :codigoPaciente and p.estado = 0")
    Paciente findPacienteActivo(int codigoPaciente);

    @Query("select c from Paciente p join Cita c where p.codigo = :codigoPaciente and c.fechaCita < CURRENT_DATE")
    List<Cita> listarHistorialAtencionesPaciente(int codigoPaciente);
}
