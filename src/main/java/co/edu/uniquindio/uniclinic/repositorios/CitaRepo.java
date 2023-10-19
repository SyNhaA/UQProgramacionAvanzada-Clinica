package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitaRepo extends JpaRepository<Cita, Integer> {

    @Query("select c from Cita c where c.medico.codigo = :codigoMedico and c.estado = 'COMPLETADA'")
    List<Cita> findCitasCompletadasMedico(int codigoMedico);

}
