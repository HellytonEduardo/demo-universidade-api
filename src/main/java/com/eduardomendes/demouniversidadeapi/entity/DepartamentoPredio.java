package com.eduardomendes.demouniversidadeapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Table(name = "departamento_predio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DepartamentoPredio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", nullable = false, unique = true, length = 8)
    private String nome;
    @OneToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
    @OneToOne
    @JoinColumn(name = "predio_id")
    private Predio predio;

}
