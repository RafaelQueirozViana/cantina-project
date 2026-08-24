package com.cantina.service;

import com.cantina.dto.LancheRequestDTO;
import com.cantina.dto.LancheResponseDTO;
import com.cantina.exception.RecursoNaoEncontradoException;
import com.cantina.exception.RegistroDuplicadoException;
import com.cantina.model.Lanche;
import com.cantina.repository.LancheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancheService {

    private final LancheRepository lancheRepository;

    public LancheService(LancheRepository lancheRepository) {
        this.lancheRepository = lancheRepository;
    }

    public LancheResponseDTO cadastrar(LancheRequestDTO dto) {

        if (dto.nome() != null && lancheRepository.existsByNome(dto.nome())) {
            throw new RegistroDuplicadoException("já existe um lanche cadastrado com esse nome");
        }


        Lanche lanche = new Lanche();
        lanche.setNome(dto.nome());
        lanche.setDescricao(dto.descricao());
        lanche.setPreco(dto.preco());
       ;

        return toResponseDTO(lancheRepository.save(lanche));
    }

    public List<LancheResponseDTO> listar(String nome, String descricao) {
        List<Lanche> lanches;
            lanches = lancheRepository.findAll();

        return lanches.stream().map(this::toResponseDTO).toList();
    }

    public LancheResponseDTO buscarPorId(Long id) {
        Lanche lanche = lancheRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("lanche não encontrado"));
        return toResponseDTO(lanche);
    }


    public LancheResponseDTO atualizar(Long id,  LancheRequestDTO dto) {
        Lanche lanche = lancheRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("lanche não encontrado"));
        lanche.setDescricao(dto.descricao());
        lanche.setPreco(dto.preco());
        lanche.setNome(dto.nome());
        return toResponseDTO(lanche);
    }





    public void remover(Long id) {
        if (!lancheRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("lanche não encontrado");
        }
        lancheRepository.deleteById(id);
    }

    private LancheResponseDTO toResponseDTO(Lanche lanche) {
        return new LancheResponseDTO(
                lanche.getId(),
                lanche.getNome(),
                lanche.getPreco()
        );
    }
}