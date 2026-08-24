package com.cantina.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record LancheRequestDTO(

        @NotBlank(message = "informe o nome do lanche")
        @Schema(example = "Hamburguer")
        String nome,

        @NotBlank(message = "informe a descrição")
        @Schema(example = "hamburguer com 160g de carne e maionese artesanal")
        String descricao,

        @NotNull(message = "informe o preço")
        @Positive(message = "preço deve ser maior que zero")
        @Schema(example = "14.00")
        BigDecimal preco


) {}