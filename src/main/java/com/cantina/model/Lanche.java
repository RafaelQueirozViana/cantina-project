package com.cantina.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "lanche")
@Getter
@Setter
@NoArgsConstructor
public class Lanche {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(example = "hamburguer")
    private String nome;

    @Column(nullable = false)
    @Schema(example = "hamburguer com alface e tomate")
    private String descricao;

    @Column(nullable = false, precision = 12, scale = 2)
    @Schema(example = "14.00")
    private BigDecimal preco;


}