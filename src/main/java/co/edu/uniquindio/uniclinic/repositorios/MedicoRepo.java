package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import co.edu.uniquindio.uniclinic.modelo.entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepo extends JpaRepository<Medico, Integer> {

    Medico findByCorreo(String correo);

    Medico findByCedula(String cedula);

    @Query("select m from Medico m where m.codigo = :codigoMedico and m.estado =  'ACTIVO'")
    Medico isActive(int codigoMedico);

    @Query("select c from Medico m join Cita c where m.codigo = :codigoMedico and c.fechaCita > CURRENT_DATE")
    List<Cita> listarCitasPendiente(int codigoMedico);

    @Query("select c from Medico m join Cita c where m.codigo = :codigoMedico")
    List<Cita> listasCitas(int codigoMedico);

}
