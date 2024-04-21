package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Professor;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.CpfUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor salvarProfessor(Professor professor){
        try {
            return professorRepository.save(professor);
        }catch (DataIntegrityViolationException ex){
            throw new CodigoUniqueViolationException(String.format("O Professor com o código: '%s' já foi cadastrado no Sistema.", professor.getCodigo()));
        }

    }

    @Transactional(readOnly = true)
    public Professor buscarProfessorPeloCodigo(String codigo) {
        return professorRepository.findProfessorByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O professor com o código: '%s' não foi encontrado.", codigo))
        );
    }

    @Transactional(readOnly = true)
    public Professor buscarProfessorPeloId(Long id) {
        return professorRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O professor com o id: '%s' não foi encontrado.", id))
        );
    }

    @Transactional(readOnly = true)
    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    @Transactional
    public Professor alterarNome(Long id, String nome) {
        Professor professor = buscarProfessorPeloId(id);
        professor.setNome(nome);
        return salvarProfessor(professor);
    }

    @Transactional
    public void deletarProfessor(Long id){
        professorRepository.deleteById(id);
    }
}
