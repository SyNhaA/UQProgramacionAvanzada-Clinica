package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;
import java.io.Serializable;
import java.time.LocalDate;

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
    private LocalDate fechaInicio;

    @Future
    @Column(nullable = false)
    private LocalDate fechaFin;

    @OneToOne
    @JoinColumn(name = "atencion_codigo", nullable = false)
    private AtencionMedica atencionMedica;

}
