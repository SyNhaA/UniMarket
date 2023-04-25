package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
        @Min(value = 1, message = "La puntuacion debe ser mayor o igual a 1")
        @Max(value = 5, message = "La puntuacion debe ser menor o igual a 5")
        private int puntuacion;

        @Column(length = 200)
        private String comentario;

        @Column(nullable = false)
        private LocalDateTime fecha;

}
