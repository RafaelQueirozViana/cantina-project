package com.cantina.controller;

import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.service.LancheService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Lanches", description = "Consulta e cadastro do estoque de lanches da cantina")
@RestController
@RequestMapping("/lanches")
public class LancheController {

    private final LancheService lancheService;

    public LancheController(LancheService lancheService) {
        this.lancheService = lancheService;
    }

    @Operation(summary = "Cadastrar lanche", description = "Cadastra um lanche no sistema da cantina")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Lanche cadastrado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "409", description = "Já existe um lanche com esse nome")
    })

    @PostMapping
    public ResponseEntity<LancheResponseDTO> cadastrar(@Valid @RequestBody LancheRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(lancheService.cadastrar(dto));
    }

    @Operation(summary = "Lista os lanches disponíveis", description = "Retorna todos os lanches")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetro filtro inválido")
    })
    @GetMapping
    public List<LancheResponseDTO> listar(
            @RequestParam(required = false) String cor,
            @RequestParam(required = false) String descricao) {
        return lancheService.listar(cor, descricao);
    }

    @Operation(summary = "Busca um lanche pelo id", description = "Retorna os dados de um lanche específico da cantina.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Lanche encontrado"),
            @ApiResponse(responseCode = "404", description = "Lanche não encontrado")
    })
    @GetMapping("/{id}")
    public LancheResponseDTO buscarPorId(@PathVariable Long id) {
        return lancheService.buscarPorId(id);
    }

    @Operation(summary = "Remove um lanche da cantina", description = "Exclui um lanche.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Lanche removido com sucesso"),
            @ApiResponse(responseCode = "404", description = "Lanche não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        lancheService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancheResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody LancheRequestDTO dto) {

        return ResponseEntity.ok(
                lancheService.atualizar(id,dto)
        );
    }



}