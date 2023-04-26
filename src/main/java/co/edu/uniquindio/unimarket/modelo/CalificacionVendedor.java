package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class CalificacionVendedor implements Serializable {

        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(nullable = false)
        private Usuario comprador;

        @ManyToOne
        @JoinColumn(nullable = false)
        private Usuario vendedor;

        @Column(nullable = false, length = 1)
        private int puntuacion;

        @Column(length = 200)
        private String comentario;

        @Column(nullable = false)
        private LocalDateTime fecha;

}
