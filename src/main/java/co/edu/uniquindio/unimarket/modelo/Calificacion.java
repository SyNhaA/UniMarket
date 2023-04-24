package co.edu.uniquindio.unimarket.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Calificacion implements Serializable {

        @Id
        @EqualsAndHashCode.Include
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(nullable = false)
        private Usuario usuario;

        @ManyToOne
        @JoinColumn(nullable = false)
        private Producto producto;

        @Column(nullable = false, length = 1)
        @Min(value = 1, message = "La puntuacion debe ser mayor o igual a 1")
        @Max(value = 5, message = "La puntuacion debe ser menor o igual a 5")
        private int puntuacion;

        @Column(length = 200)
        private String comentario;
}
