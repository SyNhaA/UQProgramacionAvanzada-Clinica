package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RecetaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(length = 250)
    private String descripcion;

    @OneToOne
    @JoinColumn(name = "atencion_codigo", nullable = false)
    private AtencionMedica atencionMedica;

    @ManyToMany(mappedBy = "recetasMedicas")
    private List<Medicamento> medicamentos;

}
