package co.edu.uniquindio.uniclinic.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Enumerated(EnumType.ORDINAL)
    private EstadoCita estado;

    @OneToOne(mappedBy = "cita")
    private Atencion atencion;

    @OneToMany(mappedBy = "cita")
    private List<PQRS> pqrs;

    @ManyToOne
    @JoinColumn(name = "paciente_codigo")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_codigo")
    private Medico medico;

}
