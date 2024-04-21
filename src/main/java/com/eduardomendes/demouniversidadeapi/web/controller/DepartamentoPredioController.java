package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.DepartamentoPredio;
import com.eduardomendes.demouniversidadeapi.service.DepartamentoPredioService;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoPredioCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoPredioResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.DepartamentoPredioMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/departamento-predio")
@RequiredArgsConstructor
@RestController
public class DepartamentoPredioController {
    private final DepartamentoPredioService departamentoPredioService;

    @PostMapping
    public ResponseEntity<DepartamentoPredioResponseDto> create(
            @Valid @RequestBody DepartamentoPredioCreateDto predioCreateDto){
        DepartamentoPredio departamentoPredio = departamentoPredioService.salvarDepartamentoPredio(
                DepartamentoPredioMapper.toDepartamento(predioCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(DepartamentoPredioMapper.toDto(departamentoPredio));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<DepartamentoPredioResponseDto> getByNome(@Valid @PathVariable String nome){
        DepartamentoPredio departamentoPredio = departamentoPredioService.buscarDepartamentoPredioPeloNome(nome);
        return ResponseEntity.ok().body(DepartamentoPredioMapper.toDto(departamentoPredio));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoPredioResponseDto>> getAll(){
        List<DepartamentoPredio> departamentoPredio = departamentoPredioService.buscarTodos();
        return ResponseEntity.ok().body(DepartamentoPredioMapper.toListDto(departamentoPredio));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        departamentoPredioService.deletarDepartamentoPredio(id);
        return ResponseEntity.noContent().build();
    }
}
