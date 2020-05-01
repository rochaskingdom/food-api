package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.entity.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();

    Cozinha porId(Long id);

    Cozinha adicionar(Cozinha cozinha);

    void remover(Cozinha cozinha);
}
