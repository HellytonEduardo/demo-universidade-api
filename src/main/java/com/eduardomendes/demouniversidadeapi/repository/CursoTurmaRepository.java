package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.CursoTurma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CursoTurmaRepository extends JpaRepository<CursoTurma, Long> {
    Optional<CursoTurma> findByCodigo(String codigo);

    List<CursoTurma> findAllByCursoCodigo(String codigo);
}