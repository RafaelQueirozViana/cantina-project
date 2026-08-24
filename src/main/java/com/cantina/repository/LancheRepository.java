package com.cantina.repository;

import com.cantina.model.Lanche;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LancheRepository extends JpaRepository<Lanche, Long> {
    boolean existsByNome(String nome);
    boolean existsByDescricao(String descricao);


}