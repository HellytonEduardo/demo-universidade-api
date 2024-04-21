package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.CursoTurma;
import com.eduardomendes.demouniversidadeapi.entity.DepartamentoPredio;
import com.eduardomendes.demouniversidadeapi.entity.LocalCurso;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.LocalCursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocalCursoService {
    private final LocalCursoRepository localCursoRepository;
    private final DepartamentoPredioService departamentoPredioService;
    private final CursoTurmaService turmaService;

    @Transactional
    public LocalCurso salvarLocalCurso(LocalCurso curso){
        CursoTurma cursoTurma = turmaService.buscarCursoTurmaPeloCodigo(curso.getCursoTurma().getCodigo());
        curso.setCursoTurma(cursoTurma);

        DepartamentoPredio departamentoPredio = departamentoPredioService.buscarDepartamentoPredioPeloNome(curso.getDepartamentoPredio().getNome());
        curso.setDepartamentoPredio(departamentoPredio);

        return localCursoRepository.save(curso);
    }

    public LocalCurso buscarLocalCursoPeloId(Long id) {
        return localCursoRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O id '%s' não foi encontrado no sistema.",id))
        );
    }

    public List<LocalCurso> buscarTodos() {
        return localCursoRepository.findAll();
    }

    public void deletarLocalCurso(Long id) {
        try {
            localCursoRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id '%s' não foi encontrado ou já foi deletado", id));
        }
    }
}
