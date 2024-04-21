package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "aluno_turma")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class AlunoTurma implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nota", length = 3)
    private int nota;
    @Column(name = "status_aluno", nullable = false, length = 12)
    @Enumerated(EnumType.STRING)
    private StatusAluno status = StatusAluno.EM_ANDAMENTO;
    @ManyToOne
    @JoinColumn(name = "turma_id")
    private Turma turma;
    @ManyToOne
    @JoinColumn(name = "aluno_id")

    private Aluno aluno;
    public enum StatusAluno{
        EM_ANDAMENTO, REPROVADO, APROVADO
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlunoTurma that = (AlunoTurma) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
