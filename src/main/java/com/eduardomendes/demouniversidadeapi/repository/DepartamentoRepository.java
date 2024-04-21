package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Optional<Departamento> findByCodigo(String codigo);
}