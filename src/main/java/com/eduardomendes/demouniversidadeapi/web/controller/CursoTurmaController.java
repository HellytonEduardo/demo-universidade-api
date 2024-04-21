package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.CursoTurma;
import com.eduardomendes.demouniversidadeapi.service.CursoTurmaService;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoTurmaCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoTurmaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.CursoTurmaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/curso-turma")
@RequiredArgsConstructor
@RestController
public class CursoTurmaController {
    private final CursoTurmaService turmaService;

    @PostMapping
    public ResponseEntity<CursoTurmaResponseDto> create(@Valid @RequestBody CursoTurmaCreateDto cursoCreateDto){
        CursoTurma cursoTurma = turmaService.salvarCursoTurma(CursoTurmaMapper.toCurso(cursoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoTurmaMapper.toDto(cursoTurma));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CursoTurmaResponseDto> getByCodigo(@Valid @PathVariable String codigo){
        CursoTurma cursoTurma = turmaService.buscarCursoTurmaPeloCodigo(codigo);
        return ResponseEntity.ok().body(CursoTurmaMapper.toDto(cursoTurma));
    }

    @GetMapping("/turmas/{codigoCurso}")
    public ResponseEntity<List<CursoTurmaResponseDto>> getAllByCodigoCurso(@Valid @PathVariable String codigoCurso){
        List<CursoTurma> cursoTurma = turmaService.buscarTodosPeloCurso(codigoCurso);
        return ResponseEntity.ok().body(CursoTurmaMapper.toListDto(cursoTurma));
    }

    @GetMapping
    public ResponseEntity<List<CursoTurmaResponseDto>> getAll(){
        List<CursoTurma> cursoTurma = turmaService.buscarTodos();
        return ResponseEntity.ok().body(CursoTurmaMapper.toListDto(cursoTurma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        turmaService.deletarCursoTurma(id);
        return ResponseEntity.noContent().build();
    }
}
