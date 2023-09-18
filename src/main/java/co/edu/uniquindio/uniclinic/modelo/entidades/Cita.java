package co.edu.uniquindio.uniclinic.modelo.entidades;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoCita;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaCita;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @OneToOne(mappedBy = "cita")
    private AtencionMedica atencionMedica;

    @OneToMany(mappedBy = "cita")
    private List<Pqrs> pqrs;

    @ManyToOne
    @JoinColumn(name = "paciente_codigo")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

}
