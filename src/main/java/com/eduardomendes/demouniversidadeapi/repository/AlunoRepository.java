package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findAlunoByCpf(String cpf);
}