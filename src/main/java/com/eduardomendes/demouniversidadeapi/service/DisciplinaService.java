package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Disciplina;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina salvarDisciplina(Disciplina disciplina){
        try {
            return disciplinaRepository.save(disciplina);
        }catch (DataIntegrityViolationException ex){
           throw new CodigoUniqueViolationException(String.format("A disciplina com o codigo '%s' já foi cadastrada.", disciplina.getCodigo()));
        }
    }
    @Transactional(readOnly = true)
    public Disciplina buscarDisciplinaPorCodigo(String codigo) {
        return disciplinaRepository.findDisciplinaByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O código '%s' da disciplina não foi encontrado no sistema", codigo))
        );
    }
    @Transactional(readOnly = true)
    public List<Disciplina> buscarTodos(){
        return disciplinaRepository.findAll();
    }

    @Transactional
    public Disciplina editarNomePeloCodigo(String codigo, String nome){
        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        disciplina.setNome(nome);
        return salvarDisciplina(disciplina);
    }
}
