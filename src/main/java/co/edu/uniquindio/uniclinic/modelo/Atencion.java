package co.edu.uniquindio.uniclinic.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Atencion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private String diagnosito;

    private String tratamiento;

    private String notas;

    @OneToOne
    @JoinColumn(name = "cita_codigo")
    private Cita cita;

    @OneToOne(mappedBy = "atencion")
    private Incapacidad incapacidad;

    @OneToOne(mappedBy = "atencion")
    private RecetaMedica recetaMedica;

}
