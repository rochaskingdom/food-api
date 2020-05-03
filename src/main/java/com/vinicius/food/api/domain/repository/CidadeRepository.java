package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade buscar(Long id);

    Cidade adicionar(Cidade cidade);

    void remover(Long id);
}
