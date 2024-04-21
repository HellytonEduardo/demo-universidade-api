package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.*;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.TurmaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {
    private final TurmaRepository turmaRepository;
    private final ProfessorService professorService;
    private final DisciplinaService disciplinaService;
    private final SalaService salaService;

    @Transactional
    public Turma salvarTurma(Turma turma) {
        try {
            Professor professor = professorService.buscarProfessorPeloCodigo(turma.getProfessor().getCodigo());
            turma.setProfessor(professor);

            Disciplina disciplina = disciplinaService.buscarDisciplinaPorCodigo(turma.getDisciplina().getCodigo());
            turma.setDisciplina(disciplina);

            Sala sala = salaService.buscarSalaLivre();
            sala.setStatus(Sala.StatusSala.OCUPADA);
            turma.setSala(sala);

            turma.setDataInicio(LocalDateTime.now());
            return turmaRepository.save(turma);
        }catch (DataIntegrityViolationException ex){
            throw new CodigoUniqueViolationException(String.format("O codigo '%s' já foi cadastrado no sistema", turma.getCodigo()));
        }
    }
    @Transactional(readOnly = true)
    public Turma buscarTurmaPeloCodigo(String codigo) {
        return turmaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException(String.format("O código da turma: '%s' não foi encontrado", codigo))
        );
    }

    @Transactional(readOnly = true)
    public Turma buscarTurmaPelaId(Long id) {
        return turmaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("A id da turma: '%s' não foi encontrada", id))
        );
    }
    @Transactional(readOnly = true)
    public List<Turma> buscarTodosPorCodigoProfessor(String codigoProfessor){
        return turmaRepository.findAllByProfessorCodigo(codigoProfessor);
    }
    @Transactional(readOnly = true)
    public List<Turma> buscarTodosPorCodigoDisciplina(String codigoDisciplina) {
        return turmaRepository.findAllByDisciplinaCodigo(codigoDisciplina);
    }
    @Transactional(readOnly = true)
    public List<Turma> buscarTodosTurmas() {
        return turmaRepository.findAll();
    }

    @Transactional
    public void deletarTurmaPelaId(Long id) {
        Turma turma = buscarTurmaPelaId(id);
        salaService.editarStatusParaLivre(turma.getSala().getId());

        turmaRepository.deleteById(id);
    }
}
