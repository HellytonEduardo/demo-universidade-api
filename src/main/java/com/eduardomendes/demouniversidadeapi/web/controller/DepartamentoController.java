package com.eduardomendes.demouniversidadeapi.web.controller;

import com.eduardomendes.demouniversidadeapi.entity.Departamento;
import com.eduardomendes.demouniversidadeapi.service.DepartamentoService;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoCreateDto;
import com.eduardomendes.demouniversidadeapi.web.dto.DepartamentoResponseDto;
import com.eduardomendes.demouniversidadeapi.web.dto.mapper.DepartamentoMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/departamentos")
@RequiredArgsConstructor
@RestController
public class DepartamentoController {
    private final DepartamentoService departamentoService;

    @PostMapping
    public ResponseEntity<DepartamentoResponseDto> create(@Valid @RequestBody DepartamentoCreateDto departamentoCreateDto){
        Departamento departamento = departamentoService.salvarDepartamento(DepartamentoMapper.toDepartamento(departamentoCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(DepartamentoMapper.toDto(departamento));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> getById(@Valid @PathVariable Long id){
        Departamento departamento = departamentoService.buscarDepartamentoPorId(id);
        return ResponseEntity.ok().body(DepartamentoMapper.toDto(departamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoResponseDto> updateById(@Valid @PathVariable Long id,
                                                              @Valid @RequestBody Departamento departamento){
        Departamento departamento1 = departamentoService.editarNomeDepartamento(id, departamento.getNome());
        return ResponseEntity.ok().body(DepartamentoMapper.toDto(departamento1));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoResponseDto>> getAll(){
        List<Departamento> departamentos = departamentoService.buscarTodos();
        return ResponseEntity.ok().body(DepartamentoMapper.toListDto(departamentos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}
