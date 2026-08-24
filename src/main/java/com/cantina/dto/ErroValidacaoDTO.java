package com.cantina.dto;

import java.util.List;

public record ErroValidacaoDTO(int status, List<ErroCampoDTO> erros) {}