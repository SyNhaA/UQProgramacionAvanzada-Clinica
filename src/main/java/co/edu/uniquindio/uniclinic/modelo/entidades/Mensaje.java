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
public class Mensaje implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int codigo;

    private LocalDateTime fechaCreacion;

    private String mensaje;

    @OneToOne
    @JoinColumn(name = "respuesta_codigo")
    private Mensaje respuesta;

    @ManyToOne
    @JoinColumn(name = "pqrs_codigo")
    private Pqrs pqrs;

    @ManyToOne
    @JoinColumn(name = "cuenta_codigo")
    private Cuenta cuenta;

}
