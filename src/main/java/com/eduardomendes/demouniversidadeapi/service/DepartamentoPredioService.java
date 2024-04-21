package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Departamento;
import com.eduardomendes.demouniversidadeapi.entity.DepartamentoPredio;
import com.eduardomendes.demouniversidadeapi.entity.Predio;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.DepartamentoPredioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoPredioService {
    private final DepartamentoService departamentoService;
    private final PredioService predioService;
    private final DepartamentoPredioRepository repository;

    @Transactional
    public DepartamentoPredio salvarDepartamentoPredio(DepartamentoPredio departamentoPredio) {
        Departamento departamento = departamentoService.buscarDepartamentoPorCodigo(departamentoPredio.getDepartamento().getCodigo());
        departamentoPredio.setDepartamento(departamento);

        Predio predio = predioService.buscarPredioComStatusLivre(departamentoPredio.getPredio().getCodigo());
        predio.setStatus(Predio.StatusPredio.OCUPADO);
        departamentoPredio.setPredio(predio);

        departamentoPredio.setNome(departamentoPredio.getDepartamento().getCodigo() + departamentoPredio.getPredio().getCodigo());
        return repository.save(departamentoPredio);
    }
    @Transactional(readOnly = true)
    public DepartamentoPredio buscarDepartamentoPredioPeloNome(String nome){
        return repository.findByNome(nome).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("O localização do departamento com o nome '%s' não foi encontrado", nome))
        );
    }
    @Transactional(readOnly = true)
    public DepartamentoPredio buscarDepartamentoPredioPeloId(Long id){
        return repository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("O localização do departamento com o id '%s' não foi encontrado", id))
        );
    }





    @Transactional(readOnly = true)
    public List<DepartamentoPredio> buscarTodos(){
        return repository.findAll();
    }

    @Transactional
    public void deletarDepartamentoPredio(Long id) {
        try {
            DepartamentoPredio predio = buscarDepartamentoPredioPeloId(id);
            predioService.editarStatusParaLivre(predio.getPredio().getCodigo());

            repository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id '%s' não foi encontrado ou já foi excluído", id));
        }
    }
}
