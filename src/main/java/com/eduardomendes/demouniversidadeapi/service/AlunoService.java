package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import com.eduardomendes.demouniversidadeapi.exception.CpfUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.AlunoRepository;
import com.eduardomendes.demouniversidadeapi.util.AlunoUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {
    private final AlunoRepository alunoRepository;

    @Transactional
    public Aluno salvarAluno(Aluno aluno){
        try {
            aluno.setMatricula(AlunoUtil.gerarCodigoMatricula());
            aluno.setDataMatricula(LocalDateTime.now());

            return alunoRepository.save(aluno);
       }catch (DataIntegrityViolationException ex){
            throw new CpfUniqueViolationException(String.format("O Aluno com o cpf: '%s' já foi cadastrado no Sistema.", aluno.getCpf()));
        }
    }
    @Transactional(readOnly = true)
    public Aluno buscarAlunoPorCpf(String cpf){
        return alunoRepository.findAlunoByCpf(cpf).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O Aluno com o cpf: '%s' não foi encontrado.", cpf))
        );
    }
    @Transactional
    public Aluno editarNome(String cpf, String nome){
        Aluno aluno = buscarAlunoPorCpf(cpf);
        aluno.setNome(nome);
        return aluno;
    }
    @Transactional
    public void deletarAlunoPeloId(Long id) {
        try {
            alunoRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O aluno com o id: '%s' não foi encontrado", id));
        }

    }
    @Transactional(readOnly = true)
    public List<Aluno> buscarTodos() {
        return alunoRepository.findAll();
    }
}
