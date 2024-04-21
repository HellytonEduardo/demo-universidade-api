package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.Predio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PredioRepository extends JpaRepository<Predio, Long> {
    Optional<Predio> findPredioByCodigo(int codigo);

    Optional<Predio> findPredioByCodigoAndStatus(int codigo, Predio.StatusPredio statusPredio);
}