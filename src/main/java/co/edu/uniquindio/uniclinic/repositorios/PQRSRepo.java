package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Pqrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PQRSRepo extends JpaRepository<Pqrs, Integer> {

    @Query("select pq from Pqrs pq where pq.cita.paciente.codigo = :codigoPaciente")
    List<Pqrs> listarPqrsPendiente(int codigoPaciente);
}
