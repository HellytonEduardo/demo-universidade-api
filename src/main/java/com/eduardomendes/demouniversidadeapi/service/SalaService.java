package com.eduardomendes.demouniversidadeapi.service;

import com.eduardomendes.demouniversidadeapi.entity.Sala;
import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.exception.CodigoUniqueViolationException;
import com.eduardomendes.demouniversidadeapi.exception.EntityNotFoundException;
import com.eduardomendes.demouniversidadeapi.repository.SalaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SalaService {
    private final SalaRepository salaRepository;

    @Transactional
    public Sala salvarSala(Sala sala) {
        try {
            return salaRepository.save(sala);
        } catch (DataIntegrityViolationException ex) {
            throw new CodigoUniqueViolationException(String.format("O codigo '%s' já foi cadastrado no Sistema", sala.getCodigo()));
        }
    }

    @Transactional(readOnly = true)
    public Sala buscarSalaPeloId(Long id) {
        return salaRepository.findSalaById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("O id da sala: '%s' não foi encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Sala buscarSalaLivre(){
        return salaRepository.findFirstByStatus(Sala.StatusSala.LIVRE).orElseThrow(
                () -> new EntityNotFoundException(String.format("Não foi encontrado nenhuma sala Livre"))
        );
    }
    @Transactional(readOnly = true)
    public List<Sala> buscarTodasSalasLivres(){
        return salaRepository.findAllByStatus(Sala.StatusSala.LIVRE);
    }

    @Transactional
    public Sala editarStatusParaLivre(Long id){
        Sala sala = buscarSalaPeloId(id);
        sala.setStatus(Sala.StatusSala.LIVRE);
        return salvarSala(sala);
    }

    @Transactional
    public Sala editarCodigoSala(Long id, String codigo){
        Sala sala = buscarSalaPeloId(id);
        sala.setCodigo(codigo);
        return salvarSala(sala);
    }
    @Transactional(readOnly = true)
    public List<Sala> buscarTodasSalasOcupadas() {
        return salaRepository.findAllByStatus(Sala.StatusSala.OCUPADA);
    }

    @Transactional
    public void deletarSala(Long id){
        try {
                salaRepository.deleteById(id);

        }catch (RuntimeException ex){
            throw new EntityNotFoundException(String.format("O id da sala '%s' não foi encotrado ou já foi deletado", id));
        }
    }
}
