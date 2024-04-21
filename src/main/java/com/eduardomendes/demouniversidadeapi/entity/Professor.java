package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Table(name = "professores")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo_professor", nullable = false, unique = true, length = 11)
    private String codigo;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "salario", columnDefinition = "decimal(7,2)")
    private BigDecimal salario;
    @Column(name = "email", nullable = false, length = 150, unique = true)
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(id, professor.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
