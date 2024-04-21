package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.DepartamentoPredio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoPredioRepository extends JpaRepository<DepartamentoPredio, Long> {
    Optional<DepartamentoPredio> findByNome(String nome);
}