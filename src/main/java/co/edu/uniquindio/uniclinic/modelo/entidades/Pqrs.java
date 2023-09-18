package co.edu.uniquindio.uniclinic.modelo.entidades;

import co.edu.uniquindio.uniclinic.modelo.enums.EstadoPQRS;
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
public class Pqrs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private LocalDateTime fechaCreacion;

    private String tipo;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private EstadoPQRS estado;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

    @ManyToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

}
