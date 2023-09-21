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

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 500)
    private String motivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPQRS estado;

    @OneToMany(mappedBy = "pqrs")
    private List<Mensaje> mensajes;

    @ManyToOne
    @JoinColumn(name = "cita_codigo", nullable = false)
    private Cita cita;

}
