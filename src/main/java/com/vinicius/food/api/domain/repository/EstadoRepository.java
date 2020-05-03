package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscar(Long id);

    Estado adicionar(Estado estado);

    void remover(Long id);
}
