package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Professor;
import com.eduardomendes.demouniversidadeapi.service.ProfessorService;
import com.eduardomendes.demouniversidadeapi.web.dto.ProfessorCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.ProfessorResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.ProfessorMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/professores")
@RequiredArgsConstructor
@RestController
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> create(@Valid @RequestBody ProfessorCreateDto professorCreateDto){
        Professor professor = professorService.salvarProfessor(ProfessorMapper.toProfessor(professorCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ProfessorMapper.toDto(professor));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProfessorResponseDto> getProfessorByCodigo(@Valid @PathVariable String codigo){
        Professor professor = professorService.buscarProfessorPeloCodigo(codigo);
        return ResponseEntity.ok().body(ProfessorMapper.toDto(professor));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorResponseDto>> getAll(){
        List<Professor> professores = professorService.buscarTodos();
        return ResponseEntity.ok().body(ProfessorMapper.toListDto(professores));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDto> updateNomeById(@Valid @PathVariable Long id,@Valid @RequestBody Professor professor){
        Professor professor1 = professorService.alterarNome(id, professor.getNome());
        return ResponseEntity.ok().body(ProfessorMapper.toDto(professor1));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

}
