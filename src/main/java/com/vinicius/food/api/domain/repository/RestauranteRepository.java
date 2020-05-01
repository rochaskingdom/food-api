package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> todos();

    Restaurante porId(Long id);

    Restaurante adicionar(Restaurante restaurante);

    void remover(Restaurante restaurante);
}
