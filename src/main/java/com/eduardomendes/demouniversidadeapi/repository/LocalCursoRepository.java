package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.LocalCurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalCursoRepository extends JpaRepository<LocalCurso, Long> {
}