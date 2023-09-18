package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AtencionMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private String diagnostico;

    private String tratamiento;

    private String notas;

    @OneToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

    @OneToOne(mappedBy = "atencionMedica")
    private Incapacidad incapacidad;

    @OneToOne(mappedBy = "atencionMedica")
    private RecetaMedica recetaMedica;

}
