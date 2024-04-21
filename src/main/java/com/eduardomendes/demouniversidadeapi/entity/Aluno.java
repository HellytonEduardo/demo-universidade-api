package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "alunos")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@ToString
@Entity
public class Aluno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "matricula", nullable = false, unique = true, length = 15)
    private String matricula;
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    private String cpf;
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDateTime dataNascimento;
    @Column(name = "data_matricula", nullable = false)
    private LocalDateTime dataMatricula;
    @Column(name = "rua", nullable = false, length = 150)
    private String rua;
    @Column(name ="numero", nullable = false, length = 5)
    private int numero;
    @Column(name = "bairro", nullable = false, length = 50)
    private String bairro;
    @Column(name = "cidade", nullable = false, length = 30)
    private String cidade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(id, aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
