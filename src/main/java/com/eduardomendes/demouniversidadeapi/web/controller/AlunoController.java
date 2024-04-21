package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Aluno;
import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import com.eduardomendes.demouniversidadeapi.service.AlunoService;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.AlunoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/alunos")
@RequiredArgsConstructor
@RestController
public class AlunoController {
    private final AlunoService alunoService;
    @PostMapping
    public ResponseEntity<AlunoResponseDto> create(@Valid @RequestBody AlunoCreateDto alunoCreateDto){
        Aluno aluno = alunoService.salvarAluno(AlunoMapper.toAluno(alunoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(AlunoMapper.toDto(aluno));
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<AlunoResponseDto> findByCpf(@Valid @PathVariable String cpf){
        Aluno aluno = alunoService.buscarAlunoPorCpf(cpf);
        return ResponseEntity.ok().body(AlunoMapper.toDto(aluno));
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Void> updateNomeByCpf(@PathVariable String cpf, @RequestBody Aluno aluno){
        alunoService.editarNome(cpf, aluno.getNome());
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponseDto>> getAll(){
        List<Aluno> alunos = alunoService.buscarTodos();
        return ResponseEntity.ok().body(AlunoMapper.toListDto(alunos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteAlunoById(@PathVariable Long id){
        alunoService.deletarAlunoPeloId(id);
        return ResponseEntity.noContent().build();
    }
}
