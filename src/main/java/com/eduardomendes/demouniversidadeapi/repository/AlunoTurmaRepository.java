package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoTurmaRepository extends JpaRepository<AlunoTurma, Long> {
    List<AlunoTurma> findAllByAlunoCpf(String cpf);

    List<AlunoTurma> findAllByTurmaCodigo(String codigo);

    List<AlunoTurma> findAllByAlunoCpfAndStatus(String cpf, AlunoTurma.StatusAluno statusAluno);

    List<AlunoTurma> findAllByTurmaCodigoAndStatus(String codigo, AlunoTurma.StatusAluno statusAluno);
}