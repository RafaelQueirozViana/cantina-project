package com.cantina.dto;

import java.math.BigDecimal;

public record LancheResponseDTO(
        Long id,
        String nome,

        BigDecimal preco

) {}