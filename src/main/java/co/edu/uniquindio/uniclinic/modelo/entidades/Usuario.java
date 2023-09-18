package co.edu.uniquindio.uniclinic.modelo.entidades;

import co.edu.uniquindio.uniclinic.modelo.enums.Ciudad;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario extends Cuenta implements Serializable {

    private String cedula;

    private String nombre;

    private String telefono;

    private String urlFoto;

    @Enumerated(EnumType.STRING)
    private Ciudad ciudad;

}
