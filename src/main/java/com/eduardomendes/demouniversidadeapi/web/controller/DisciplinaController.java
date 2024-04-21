package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Disciplina;
import com.eduardomendes.demouniversidadeapi.service.DisciplinaService;
import com.eduardomendes.demouniversidadeapi.web.dto.DisciplinaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DisciplinaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.DisciplinaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/disciplinas")
@RequiredArgsConstructor
@RestController
public class DisciplinaController {
    private final DisciplinaService disciplinaService;
    @PostMapping
    public ResponseEntity<DisciplinaResponseDto> create(@Valid @RequestBody DisciplinaCreateDto disciplinaCreateDto){
        Disciplina disciplina = disciplinaService.salvarDisciplina(DisciplinaMapper.toDisciplina(disciplinaCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(DisciplinaMapper.toDto(disciplina));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DisciplinaResponseDto> getByCodigo(@Valid @PathVariable String codigo){
        Disciplina disciplina = disciplinaService.buscarDisciplinaPorCodigo(codigo);
        return ResponseEntity.ok().body(DisciplinaMapper.toDto(disciplina));
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDto>> getAll(){
        List<Disciplina> disciplina = disciplinaService.buscarTodos();
        return ResponseEntity.ok().body(DisciplinaMapper.toListDto(disciplina));
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DisciplinaResponseDto> updateNome(@Valid @PathVariable String codigo,
                                                            @Valid @RequestBody Disciplina disciplina){
        Disciplina disciplinas = disciplinaService.editarNomePeloCodigo(codigo, disciplina.getNome());
        return ResponseEntity.ok().body(DisciplinaMapper.toDto(disciplinas));
    }
}
