package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Curso;
import com.eduardomendes.demouniversidadeapi.entity.Departamento;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DepartamentoService {
    private final DepartamentoRepository departamentoRepository;
    @Transactional
    public Departamento salvarDepartamento(Departamento departamento){

        return departamentoRepository.save(departamento);
    }

    @Transactional(readOnly = true)
    public Departamento buscarDepartamentoPorId(Long id){
        return departamentoRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O id do departamento '%s' não foi encontrado.", id))
        );
    }
    @Transactional(readOnly = true)
    public Departamento buscarDepartamentoPorCodigo(String codigo){
        return departamentoRepository.findByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(String.format("O codigo do departamento '%s' não foi encontrado.", codigo))
        );
    }
    @Transactional
    public Departamento editarNomeDepartamento(Long id, String nome){
        Departamento departamento = buscarDepartamentoPorId(id);
        departamento.setNome(nome);

        return salvarDepartamento(departamento);
    }

    @Transactional
    public void deletarDepartamento(Long id){
        try {
            departamentoRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id do departamento '%s' não foi encontrado ou já foi deletado.", id));
        }
    }

    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos(){
        return departamentoRepository.findAll();
    }
}
