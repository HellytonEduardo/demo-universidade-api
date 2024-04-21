package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "curso_turma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CursoTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo", nullable = false, unique = true, length = 6)
    private String codigo;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    @OneToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoTurma that = (CursoTurma) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
