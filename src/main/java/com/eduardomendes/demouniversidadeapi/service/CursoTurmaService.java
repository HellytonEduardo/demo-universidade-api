package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Curso;
import com.eduardomendes.demouniversidadeapi.entity.CursoTurma;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.CursoTurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoTurmaService {
    private final CursoTurmaRepository cursoTurmaRepository;
    private final CursoService cursoService;
    private final TurmaService turmaService;

    @Transactional
    public CursoTurma salvarCursoTurma(CursoTurma cursoTurma){
        Curso curso = cursoService.buscarCursoPeloCodigo(cursoTurma.getCurso().getCodigo());
        cursoTurma.setCurso(curso);

        Turma turma = turmaService.buscarTurmaPeloCodigo(cursoTurma.getTurma().getCodigo());
        cursoTurma.setTurma(turma);

        cursoTurma.setCodigo(turma.getCodigo());
        return cursoTurmaRepository.save(cursoTurma);
    }

    @Transactional(readOnly = true)
    public CursoTurma buscarCursoTurmaPeloCodigo(String codigo){
        return cursoTurmaRepository.findByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O codigo '%s' não foi encontrado", codigo))
        );
    }

    @Transactional(readOnly = true)
    public List<CursoTurma> buscarTodos(){
        return cursoTurmaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<CursoTurma> buscarTodosPeloCurso(String codigo){
        return cursoTurmaRepository.findAllByCursoCodigo(codigo);
    }

    @Transactional
    public void deletarCursoTurma(Long id) {
        try {
            cursoTurmaRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(
                    String.format("O id '%s' não foi encontrado ou já foi deletado", id)
            );
        }
    }
}
