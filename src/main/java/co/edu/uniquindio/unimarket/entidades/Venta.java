package co.edu.uniquindio.unimarket.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Venta implements Serializable{

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue
    private int id;
}
