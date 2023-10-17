package co.edu.uniquindio.uniclinic.modelo.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    @Column(nullable = false, length = 75)
    private String nombre;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false, length = 40)
    private String viaAdministracion;

    @Column(nullable = false, length = 60)
    private String dosis;

    @ManyToMany
    @JoinTable(name = "medicamento_receta",
            joinColumns = @JoinColumn(name = "medicamento_codigo"),
            inverseJoinColumns = @JoinColumn(name = "receta_codigo"))
    private List<RecetaMedica> recetasMedicas;

}
