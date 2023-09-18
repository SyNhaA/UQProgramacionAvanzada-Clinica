package co.edu.uniquindio.uniclinic.modelo.entidades;

import co.edu.uniquindio.uniclinic.modelo.enums.EPS;
import co.edu.uniquindio.uniclinic.modelo.enums.TipoSangre;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Paciente extends Usuario implements Serializable {

    private LocalDateTime fechaNacimiento;

    @ElementCollection
    private List<String> alergias;

    @Enumerated(EnumType.STRING)
    private EPS eps;

    @Enumerated(EnumType.STRING)
    private TipoSangre tipoSangre;

    @OneToMany(mappedBy = "paciente")
    private List<Cita> citas;

}
