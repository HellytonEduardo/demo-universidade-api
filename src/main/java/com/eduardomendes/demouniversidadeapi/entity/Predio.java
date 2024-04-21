package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "predios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Predio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo_predio", nullable = false, unique = true, length = 3)
    private int codigo;
    @Column(name = "nome_predio", nullable = false, length = 30)
    private String nome;
    @Column(name = "status_predio", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusPredio status = StatusPredio.LIVRE;

    public enum StatusPredio{
        LIVRE, OCUPADO
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Predio predio = (Predio) o;
        return Objects.equals(id, predio.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
