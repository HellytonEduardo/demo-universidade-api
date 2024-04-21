package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Sala;
import com.eduardomendes.demouniversidadeapi.repository.SalaRepository;
import com.eduardomendes.demouniversidadeapi.service.SalaService;
import com.eduardomendes.demouniversidadeapi.web.dto.SalaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.SalaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.SalaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/salas")
@RequiredArgsConstructor
@RestController
public class SalaController {
    private final SalaService salaService;

    @PostMapping
    public ResponseEntity<SalaResponseDto> create(@Valid @RequestBody SalaCreateDto salaCreateDto){
        Sala sala = salaService.salvarSala(SalaMapper.toSala(salaCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaMapper.toDto(sala));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDto> getById(@Valid @PathVariable Long id){
        Sala sala = salaService.buscarSalaPeloId(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(SalaMapper.toDto(sala));
    }
    @GetMapping("/livres")
    public ResponseEntity<List<SalaResponseDto>> getAllLivres(){
        List<Sala> salas = salaService.buscarTodasSalasLivres();
        return ResponseEntity.ok().body(SalaMapper.toListDto(salas));
    }
    @GetMapping("/ocupadas")
    public ResponseEntity<List<SalaResponseDto>> getAllOcupadas(){
        List<Sala> salas = salaService.buscarTodasSalasOcupadas();
        return ResponseEntity.ok().body(SalaMapper.toListDto(salas));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SalaResponseDto> updateById(@Valid @PathVariable Long id,@Valid @RequestBody Sala sala){
        Sala salas = salaService.editarCodigoSala(id, sala.getCodigo());
        return ResponseEntity.ok().body(SalaMapper.toDto(sala));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        salaService.deletarSala(id);
        return ResponseEntity.noContent().build();
    }
}
