package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.repository.AlunoTurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoAlunoService {

    private final AlunoTurmaRepository alunoTurmaRepository;

    @Transactional(readOnly = true)
    public List<AlunoTurma> buscarTurmasMatriculadasPorCpf(String cpf) {
        return alunoTurmaRepository.findAllByAlunoCpf(cpf);
    }

    @Transactional(readOnly = true)
    public List<AlunoTurma> buscarAlunoTurmaAprovadosPorCpf(String cpf){
        return alunoTurmaRepository.findAllByAlunoCpfAndStatus(cpf, AlunoTurma.StatusAluno.APROVADO);
    }
    @Transactional(readOnly = true)
    public List<AlunoTurma> buscarAlunoTurmaReprovadosPorCpf(String cpf){
        return alunoTurmaRepository.findAllByAlunoCpfAndStatus(cpf, AlunoTurma.StatusAluno.REPROVADO);
    }
}
