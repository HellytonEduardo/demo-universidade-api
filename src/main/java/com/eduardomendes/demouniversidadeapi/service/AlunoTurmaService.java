package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.AlunoTurmaRepository;
import com.eduardomendes.demouniversidadeapi.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoTurmaService {
    private final AlunoTurmaRepository alunoTurmaRepository;
    private final TurmaService turmaService;
    private final AlunoService alunoService;

    @Transactional
    public AlunoTurma salvarAlunoTurma(AlunoTurma alunoTurma){
        Turma turma = turmaService.buscarTurmaPeloCodigo(alunoTurma.getTurma().getCodigo());
        alunoTurma.setTurma(turma);

        Aluno aluno = alunoService.buscarAlunoPorCpf(alunoTurma.getAluno().getCpf());
        alunoTurma.setAluno(aluno);
        return alunoTurmaRepository.save(alunoTurma);
    }

    @Transactional(readOnly = true)
    public AlunoTurma buscarAlunoTurmaPeloId(Long id){
        return alunoTurmaRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O ID do aluno: '%s' não foi encontrado.", id))
        );
    }

    @Transactional
    public AlunoTurma editarNotaTurmaPeloId(Long id, int nota) {
        AlunoTurma alunoTurma = buscarAlunoTurmaPeloId(id);
        if (nota >= 60){
            alunoTurma.setStatus(AlunoTurma.StatusAluno.APROVADO);
        }else {
            alunoTurma.setStatus(AlunoTurma.StatusAluno.REPROVADO);
        }
        alunoTurma.setNota(nota);
        return salvarAlunoTurma(alunoTurma);
    }

    public List<AlunoTurma> buscarTodos() {
        return alunoTurmaRepository.findAll();
    }

    public void deletarAlunoTurma(Long id){
        try {
            alunoTurmaRepository.deleteById(id);
        }catch (RuntimeException exception){
            throw new EntityNotFoundException(String.format("O id '%s' não foi encontrado ou já foi deletado", id));
        }
    }

    public List<AlunoTurma> buscarTodosAprovadosTurma(String codigo){
        return alunoTurmaRepository.findAllByTurmaCodigoAndStatus(codigo, AlunoTurma.StatusAluno.APROVADO);
    }

    public List<AlunoTurma> buscarTodosReprovadosTurma(String codigo){
        return alunoTurmaRepository.findAllByTurmaCodigoAndStatus(codigo, AlunoTurma.StatusAluno.REPROVADO);
    }

    public List<AlunoTurma> buscarTodosPendentesTurma(String codigo){
        return alunoTurmaRepository.findAllByTurmaCodigoAndStatus(codigo, AlunoTurma.StatusAluno.EM_ANDAMENTO);
    }

    @Transactional(readOnly = true)
    public List<AlunoTurma> buscarAlunoPorCodigoTurma(String codigo){
        return alunoTurmaRepository.findAllByTurmaCodigo(codigo);
    }
}
