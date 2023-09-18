package co.edu.uniquindio.uniclinic.modelo.entidades;

import co.edu.uniquindio.uniclinic.modelo.enums.Especialidad;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Medico extends Usuario implements Serializable {

    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;

    @OneToMany(mappedBy = "medico")
    private List<Cita> citas;

    @OneToMany(mappedBy = "medico")
    private List<HorarioMedico> horarios;

    @OneToMany(mappedBy = "medico")
    private List<DiaLibre> diasLibres;

}
