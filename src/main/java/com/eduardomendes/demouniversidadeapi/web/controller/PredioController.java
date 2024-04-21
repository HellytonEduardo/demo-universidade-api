package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Predio;
import com.eduardomendes.demouniversidadeapi.service.PredioService;
import com.eduardomendes.demouniversidadeapi.web.dto.PredioCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.PredioResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.PredioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/predios")
@RequiredArgsConstructor
@RestController
public class PredioController {
    private final PredioService predioService;

    @PostMapping
    public ResponseEntity<PredioResponseDto> create(@Valid @RequestBody PredioCreateDto predioCreateDto){
        Predio predio = predioService.salvarPredio(PredioMapper.toPredio(predioCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(PredioMapper.toDto(predio));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<PredioResponseDto> getByCodigo(@Valid @PathVariable int codigo){
        Predio predio = predioService.buscarPredioPeloCodigo(codigo);
        return ResponseEntity.ok().body(PredioMapper.toDto(predio));
    }

    @GetMapping
    public ResponseEntity<List<PredioResponseDto>> getAll(){
        List<Predio> predio = predioService.buscarTodos();
        return ResponseEntity.ok().body(PredioMapper.toListDto(predio));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<PredioResponseDto> updateByCodigo(@Valid @PathVariable int codigo,
                                                         @Valid @RequestBody Predio predio){
        Predio predios = predioService.editarNomePeloCodigo(codigo, predio.getNome());
        return ResponseEntity.ok().body(PredioMapper.toDto(predios));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        predioService.deletarPredio(id);
        return ResponseEntity.noContent().build();
    }
}
