package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Curso;
import com.eduardomendes.demouniversidadeapi.service.CursoService;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.CursoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.CursoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/cursos")
@RequiredArgsConstructor
@RestController
public class CursoController{
    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoResponseDto> create(@Valid @RequestBody CursoCreateDto cursoCreateDto){
        Curso curso = cursoService.salvarCurso(CursoMapper.toCurso(cursoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(CursoMapper.toDto(curso));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<CursoResponseDto> getByCodigo(@Valid @PathVariable String codigo){
        Curso curso = cursoService.buscarCursoPeloCodigo(codigo);
        return ResponseEntity.ok().body(CursoMapper.toDto(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CursoResponseDto> updateCurso(@Valid @PathVariable Long id, @Valid @RequestBody Curso curso){
        Curso cursos = cursoService.editarCursoPeloId(id, curso.getNome());
        return ResponseEntity.ok().body(CursoMapper.toDto(cursos));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@Valid @PathVariable Long id){
        cursoService.deletarCursoPeloId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CursoResponseDto>> getAll(){
        List<Curso> cursos = cursoService.buscarTodos();
        return ResponseEntity.ok().body(CursoMapper.toListDto(cursos));
    }
}
