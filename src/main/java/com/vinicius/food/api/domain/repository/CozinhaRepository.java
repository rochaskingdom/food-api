package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    Cozinha buscar(Long id);

    Cozinha adicionar(Cozinha cozinha);

    void remover(Long id);
}
