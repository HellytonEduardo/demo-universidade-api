package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Predio;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.PredioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PredioService {
    private final PredioRepository predioRepository;
    public Predio salvarPredio(Predio predio){
        try {
            return predioRepository.save(predio);
        }catch (DataIntegrityViolationException ex){
            throw new CodigoUniqueViolationException(
                    String.format("O código do prédio '%s' já foi cadastrado.", predio.getCodigo())
            );
        }
    }
    @Transactional(readOnly = true)
    public Predio buscarPredioPeloCodigo(int codigo){
        return predioRepository.findPredioByCodigo(codigo).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("O codigo do prédio '%s' não foi encontrado", codigo))
        );
    }
    @Transactional
    public Predio editarNomePeloCodigo(int codigo, String nome){
        Predio predio = buscarPredioPeloCodigo(codigo);
        predio.setNome(nome);

        return salvarPredio(predio);
    }



    @Transactional
    public void deletarPredio(Long id){
        try {
            predioRepository.deleteById(id);
        }catch (RuntimeException ex){
            throw new EntityNotFoundException(
                    String.format("O id do prédio '%s' não foi encontrado ou já foi deletado",id)
            );
        }
    }

    @Transactional(readOnly = true)
    public Predio buscarPredioComStatusLivre(int codigo){
        return predioRepository.findPredioByCodigoAndStatus(codigo, Predio.StatusPredio.LIVRE).orElseThrow(
                ()-> new EntityNotFoundException(
                        String.format("O prédio do código '%s' não foi encontrado ou não está livre.",codigo))
        );
    }

    @Transactional(readOnly = true)
    public List<Predio> buscarTodos(){
        return predioRepository.findAll();
    }

    public Predio editarStatusParaLivre(int codigo) {
        Predio predio = buscarPredioPeloCodigo(codigo);
        predio.setStatus(Predio.StatusPredio.LIVRE);
        return salvarPredio(predio);
    }
}
