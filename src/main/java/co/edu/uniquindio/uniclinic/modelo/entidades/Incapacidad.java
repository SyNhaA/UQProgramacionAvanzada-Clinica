package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Incapacidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 200)
    private String motivo;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaInicio;

    @Future
    @Column(nullable = false)
    private LocalDateTime fechaFin;

    @OneToOne
    @JoinColumn(name = "atencion_codigo", nullable = false)
    private AtencionMedica atencionMedica;

}
