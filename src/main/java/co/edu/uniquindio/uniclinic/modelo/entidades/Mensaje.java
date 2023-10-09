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

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(nullable = false, length = 500)
    private String mensaje;

    @OneToOne
    @JoinColumn(name = "msjpadre_codigo", nullable = false)
    private Mensaje mensajePadre;

    @ManyToOne
    @JoinColumn(name = "pqrs_codigo", nullable = false)
    private Pqrs pqrs;

    @ManyToOne
    @JoinColumn(name = "cuenta_codigo", nullable = false)
    private Cuenta cuenta;

}
