package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.TelefoneAluno;
import com.eduardomendes.demouniversidadeapi.service.TelefoneAlunoService;
import com.eduardomendes.demouniversidadeapi.web.dto.TelefoneAlunoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.TelefoneAlunoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.TelefoneAlunoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/telefones")
@RequiredArgsConstructor
@RestController
public class TelefoneAlunoController {

    private final TelefoneAlunoService telefoneAlunoService;
    @PostMapping
    public ResponseEntity<TelefoneAlunoResponseDto> create(@Valid @RequestBody TelefoneAlunoCreateDto telefoneAlunoCreateDto){
        TelefoneAluno telefoneAluno = telefoneAlunoService.salvarTelefone(TelefoneAlunoMapper.toTelefone(telefoneAlunoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(TelefoneAlunoMapper.toDto(telefoneAluno));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<TelefoneAlunoResponseDto>> getAllByCpf(@Valid @PathVariable String cpf){
        List<TelefoneAluno> telefoneAlunos = telefoneAlunoService.buscarTodosPorCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(TelefoneAlunoMapper.toListDto(telefoneAlunos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelefoneAlunoResponseDto> updateTelefone(@Valid @PathVariable Long id,@Valid @RequestBody TelefoneAluno telefoneAluno){
        TelefoneAluno telefoneAlunos = telefoneAlunoService.editarTelefone(id, telefoneAluno.getTelefone());
        return ResponseEntity.ok().body(TelefoneAlunoMapper.toDto(telefoneAlunos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable Long id){
        telefoneAlunoService.deletarTelefone(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TelefoneAlunoResponseDto>> getAll(){
        List<TelefoneAluno> telefoneAlunos = telefoneAlunoService.buscarTodos();
        return ResponseEntity.ok().body(TelefoneAlunoMapper.toListDto(telefoneAlunos));
    }
}
