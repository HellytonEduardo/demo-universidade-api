package com.eduardomendes.demouniversidadeapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Table(name = "sala")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Sala implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "codigo_sala", nullable = false, unique = true, length = 5)
    private String codigo;
    @Column(name = "status_sala", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusSala status = StatusSala.LIVRE;

    public enum StatusSala{
        LIVRE, OCUPADA
    }
}
