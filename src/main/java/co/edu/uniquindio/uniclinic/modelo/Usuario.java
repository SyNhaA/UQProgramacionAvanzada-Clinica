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
public class Usuario implements Serializable {

    @Id
    @EqualsAndHashCode.Include
    private String cedula;

    private String nombre;

    private String telefono;

    private String urlFoto;

    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

}
