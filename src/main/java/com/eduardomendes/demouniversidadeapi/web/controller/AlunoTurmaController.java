package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.service.AlunoTurmaService;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoTurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoTurmaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.AlunoTurmaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/turmas/alunos")
@RequiredArgsConstructor
@RestController
public class AlunoTurmaController {
    private final AlunoTurmaService alunoTurmaService;
    @PostMapping
    public ResponseEntity<AlunoTurmaResponseDto> create(@Valid @RequestBody AlunoTurmaCreateDto turmaCreateDto){
        AlunoTurma alunoTurma = alunoTurmaService.salvarAlunoTurma(AlunoTurmaMapper.toAlunoTurma(turmaCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoTurmaMapper.toDto(alunoTurma));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoTurmaResponseDto> updateNotaById(@Valid @PathVariable Long id, @RequestBody AlunoTurma alunoTurma){
        AlunoTurma alunoTurmas = alunoTurmaService.editarNotaTurmaPeloId(id, alunoTurma.getNota());
        return ResponseEntity.ok().body(AlunoTurmaMapper.toDto(alunoTurmas));
    }

    @GetMapping
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAll(){
        List<AlunoTurma> alunoTurma = alunoTurmaService.buscarTodos();
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(alunoTurma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        alunoTurmaService.deletarAlunoTurma(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{codigo}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllByCodigoTurma(@Valid @PathVariable String codigo){
        List<AlunoTurma> alunoTurma = alunoTurmaService.buscarAlunoPorCodigoTurma(codigo);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(alunoTurma));
    }

    @GetMapping("/aprovados/{codigo}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllByCodigoTurmaAndStatusAprovado(@Valid @PathVariable String codigo){
        List<AlunoTurma> turmas = alunoTurmaService.buscarTodosAprovadosTurma(codigo);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(turmas));
    }

    @GetMapping("/reprovados/{codigo}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllByCodigoTurmaAndStatusReprovados(@Valid @PathVariable String codigo){
        List<AlunoTurma> turmas = alunoTurmaService.buscarTodosReprovadosTurma(codigo);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(turmas));
    }

    @GetMapping("/pendentes/{codigo}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllByCodigoTurmaAndStatusEmAndamento(@Valid @PathVariable String codigo){
        List<AlunoTurma> turmas = alunoTurmaService.buscarTodosPendentesTurma(codigo);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(turmas));
    }
}

