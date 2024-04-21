package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Curso;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository cursoRepository;

    @Transactional
    public Curso salvarCurso(Curso curso){
        try {
            return cursoRepository.save(curso);
        }catch (DataIntegrityViolationException ex){
            throw new CodigoUniqueViolationException(String.format("O código do curso: '%s' já foi cadastrado no sistema.", curso.getCodigo())
            );
        }
    }

    @Transactional(readOnly = true)
    public Curso buscarCursoPeloCodigo(String codigo){
        return cursoRepository.findByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O código do curso: '%s' não foi encontrado", codigo))
        );
    }

    @Transactional(readOnly = true)
    public Curso buscarCursoPeloId(Long id){
        return cursoRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O id do curso: '%s' não foi encontrado", id))
        );
    }
    @Transactional
    public Curso editarCursoPeloId(Long id, String nome){
        Curso curso = buscarCursoPeloId(id);
        curso.setNome(nome);
        return salvarCurso(curso);
    }
    @Transactional
    public void deletarCursoPeloId(Long id){
        try {
            cursoRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id do curso: '%s': não foi encontrado ou já foi deletado.", id));
        }
    }

    @Transactional(readOnly = true)
    public List<Curso> buscarTodos() {
        return cursoRepository.findAll();
    }
}
