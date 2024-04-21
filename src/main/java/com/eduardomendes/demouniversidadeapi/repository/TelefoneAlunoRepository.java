package com.eduardomendes.demouniversidadeapi.repository;

import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TelefoneAlunoRepository extends JpaRepository<TelefoneAluno, Long> {
    Optional<List<TelefoneAluno>> findAllByAlunoCpf(String cpf);

    Optional<TelefoneAluno> findTelefoneById(Long id);
}