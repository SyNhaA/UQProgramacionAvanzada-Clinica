package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.AtencionMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtencionRepo extends JpaRepository<AtencionMedica, Integer> {

    Optional<AtencionMedica> findByCitaCodigo(int codigoCita);

}
