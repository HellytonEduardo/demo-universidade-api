package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    Optional<Sala> findSalaById(Long id);
    Optional<Sala> findFirstByStatus(Sala.StatusSala statusSala);
    List<Sala> findAllByStatus(Sala.StatusSala statusSala);
}