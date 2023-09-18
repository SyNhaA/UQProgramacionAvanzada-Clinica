package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class HorarioMedico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private LocalDate dia;

    private LocalTime horaInicio;

    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

}
