package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
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

    private String motivo;

    private LocalDateTime fechaInicio;

    private LocalDateTime fechaFin;

    @OneToOne
    @JoinColumn(name = "atencion_codigo")
    private AtencionMedica atencionMedica;

}
