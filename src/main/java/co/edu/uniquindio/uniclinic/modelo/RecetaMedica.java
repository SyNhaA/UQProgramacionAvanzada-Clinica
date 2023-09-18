package co.edu.uniquindio.uniclinic.modelo;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RecetaMedica implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private String descripcion;

    @OneToOne
    @JoinColumn(name = "atencion_codigo")
    private Atencion atencion;

    @ManyToMany(mappedBy = "recetasMedicas")
    private List<Medicamento> medicamentos;

}
