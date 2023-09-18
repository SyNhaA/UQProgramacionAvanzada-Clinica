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
public class Medicamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private String nombre;

    private int cantidad;

    private String descripcion;

    private String instrucciones;

    @ManyToMany
    @JoinTable(name = "medicamento_receta",
            joinColumns = @JoinColumn(name = "medicamento_codigo"),
            inverseJoinColumns = @JoinColumn(name = "receta_codigo"))
    private List<RecetaMedica> recetasMedicas;

}
