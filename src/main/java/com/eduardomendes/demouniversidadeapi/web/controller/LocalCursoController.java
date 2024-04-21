package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.LocalCurso;
import com.eduardomendes.demouniversidadeapi.service.LocalCursoService;
import com.eduardomendes.demouniversidadeapi.web.dto.LocalCursoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.LocalCursoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.LocalCursoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/localizar-curso")
@RequiredArgsConstructor
@RestController
public class LocalCursoController {
    private final LocalCursoService localCursoService;

    @PostMapping
    public ResponseEntity<LocalCursoResponseDto> create(@Valid @RequestBody LocalCursoCreateDto cursoCreateDto){
        LocalCurso localCurso = localCursoService.salvarLocalCurso(LocalCursoMapper.toLocalCurso(cursoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(LocalCursoMapper.toDto(localCurso));
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalCursoResponseDto> getById(@Valid @PathVariable Long id){
        LocalCurso localCurso = localCursoService.buscarLocalCursoPeloId(id);
        return ResponseEntity.ok().body(LocalCursoMapper.toDto(localCurso));
    }

    @GetMapping
    public ResponseEntity<List<LocalCursoResponseDto>> getAll(){
        List<LocalCurso> localCurso = localCursoService.buscarTodos();
        return ResponseEntity.ok().body(LocalCursoMapper.toListDto(localCurso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        localCursoService.deletarLocalCurso(id);;
        return ResponseEntity.noContent().build();
    }
}
