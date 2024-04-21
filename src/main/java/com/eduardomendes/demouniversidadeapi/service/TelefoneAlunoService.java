package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.TelefoneAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TelefoneAlunoService {
    private final TelefoneAlunoRepository telefoneAlunoRepository;
    private final AlunoService alunoService;
    @Transactional
    public TelefoneAluno salvarTelefone(TelefoneAluno telefoneAluno) {
        Aluno aluno = alunoService.buscarAlunoPorCpf(telefoneAluno.getAluno().getCpf());
        telefoneAluno.setAluno(aluno);

        return telefoneAlunoRepository.save(telefoneAluno);
    }
    @Transactional(readOnly = true)
    public List<TelefoneAluno> buscarTodosPorCpf(String cpf) {
        return telefoneAlunoRepository.findAllByAlunoCpf(cpf).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O cpf '%s' não foi encontrado no sistema.", cpf))
        );
    }

    @Transactional(readOnly = true)
    public TelefoneAluno buscarTelefonePorId(Long id){
        return telefoneAlunoRepository.findTelefoneById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O telefone com o id: '%s' não foi encontrado.", id))
        );
    }
    @Transactional
    public TelefoneAluno editarTelefone(Long id, String telefone){
        TelefoneAluno telefoneAlunos = buscarTelefonePorId(id);
        telefoneAlunos.setTelefone(telefone);
        return salvarTelefone(telefoneAlunos);
    }

    @Transactional
    public void deletarTelefone(Long id){
        try {
            telefoneAlunoRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id do telefone: '%s' não foi encontrado ou já foi excluído", id));
        }
    }
    @Transactional(readOnly = true)
    public List<TelefoneAluno> buscarTodos(){
        return telefoneAlunoRepository.findAll();
    }
}
