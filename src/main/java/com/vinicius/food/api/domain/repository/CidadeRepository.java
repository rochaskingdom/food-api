package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.entity.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();

    Cidade buscar(Long id);

    Cidade salvar(Cidade cidade);

    void remover(Cidade cidade);
}
