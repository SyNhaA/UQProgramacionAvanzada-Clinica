package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import co.edu.uniquindio.uniclinic.modelo.enums.EstadoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {

    Medico findByCedula(String cedula);

    Medico findByCorreo(String correo);

    Medico findByCedulaAndCodigoNot(String cedula, int codigo);

    Medico findByCorreoAndCodigoNot(String correo, int codigo);

    List<Medico> findAllByEstado(EstadoUsuario estado);

    List<Medico> findAllByEstadoAndEspecialidad(EstadoUsuario estado, Especialidad especialidad);

    @Query("select m from Medico m where m.codigo = :codigoMedico and m.estado = 0")
    Medico findActivo(int codigoMedico);

    @Query("select c from Medico m join m.citas c where m.codigo = :codigoMedico and c.fechaCita > CURRENT_DATE")
    List<Cita> listarCitasPendiente(int codigoMedico);

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico")
    List<Cita> listasCitas(int codigoMedico);

}
