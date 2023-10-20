package co.edu.uniquindio.uniclinic.repositorios;

import co.edu.uniquindio.uniclinic.modelo.entidades.Medicamento;
import co.edu.uniquindio.uniclinic.modelo.entidades.RecetaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetaMedicaRepo extends JpaRepository<RecetaMedica, Integer> {

    Optional<RecetaMedica> findByAtencionMedicaCodigo(int codigoAtencion);

    @Query("select rm.medicamentos from RecetaMedica rm where rm.codigo = :codigoReceta")
    List<Medicamento> findMedicamentosByCodigoReceta(int codigoReceta);

}
