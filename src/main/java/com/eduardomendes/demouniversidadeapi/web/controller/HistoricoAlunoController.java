package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.AlunoTurma;
import com.eduardomendes.demouniversidadeapi.service.HistoricoAlunoService;
import com.eduardomendes.demouniversidadeapi.web.dto.AlunoTurmaResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.AlunoTurmaMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/api/v1/turmas/historico-alunos")
@RequiredArgsConstructor
@RestController
public class HistoricoAlunoController {

    private final HistoricoAlunoService historicoAlunoService;

    @GetMapping("/{cpf}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllByCpf(@Valid @PathVariable String cpf){
        List<AlunoTurma> alunoTurma = historicoAlunoService.buscarTurmasMatriculadasPorCpf(cpf);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(alunoTurma));
    }

    @GetMapping("/aprovados/{cpf}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllAprovadosByCpf(@Valid @PathVariable String cpf){
        List<AlunoTurma> alunoTurma = historicoAlunoService.buscarAlunoTurmaAprovadosPorCpf(cpf);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(alunoTurma));
    }

    @GetMapping("/reprovados/{cpf}")
    public ResponseEntity<List<AlunoTurmaResponseDto>> getAllReprovadosByCpf(@Valid @PathVariable String cpf){
        List<AlunoTurma> alunoTurma = historicoAlunoService.buscarAlunoTurmaReprovadosPorCpf(cpf);
        return ResponseEntity.ok().body(AlunoTurmaMapper.toListDto(alunoTurma));
    }



}
