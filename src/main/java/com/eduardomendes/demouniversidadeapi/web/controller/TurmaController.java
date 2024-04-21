package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Turma;
import com.eduardomendes.demouniversidadeapi.service.TurmaService;
import com.eduardomendes.demouniversidadeapi.web.dto.TurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.TurmaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.TurmaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/turmas")
@RequiredArgsConstructor
@RestController
public class TurmaController {
    private final TurmaService turmaService;

    @PostMapping
    public ResponseEntity<TurmaResponseDto> create(@Valid @RequestBody TurmaCreateDto turmaCreateDto){
        Turma turma = turmaService.salvarTurma(TurmaMapper.toTurma(turmaCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TurmaMapper.toDto(turma));
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<TurmaResponseDto>  getByCodigo(@Valid @PathVariable String codigo){
        Turma turmas = turmaService.buscarTurmaPeloCodigo(codigo);
        return ResponseEntity.ok().body(TurmaMapper.toDto(turmas));
    }
    @GetMapping("/professores/{codigoProfessor}")
    public ResponseEntity<List<TurmaResponseDto>> getAllByCodigoProfessor(@Valid @PathVariable String codigoProfessor){
        List<Turma> turmas = turmaService.buscarTodosPorCodigoProfessor(codigoProfessor);
        return ResponseEntity.ok().body(TurmaMapper.toListDto(turmas));
    }
    @GetMapping("/disciplinas/{codigoDisciplina}")
    public ResponseEntity<List<TurmaResponseDto>> getAllByDisciplinaCodigo(@Valid @PathVariable String codigoDisciplina){
        List<Turma> turmas = turmaService.buscarTodosPorCodigoDisciplina(codigoDisciplina);
        return ResponseEntity.ok().body(TurmaMapper.toListDto(turmas));
    }
    @GetMapping
    public ResponseEntity<List<TurmaResponseDto>> getAll(){
        List<Turma> turmas = turmaService.buscarTodosTurmas();
        return ResponseEntity.ok().body(TurmaMapper.toListDto(turmas));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCodigo(@Valid @PathVariable Long id){
        turmaService.deletarTurmaPelaId(id);
        return ResponseEntity.noContent().build();
    }
}
