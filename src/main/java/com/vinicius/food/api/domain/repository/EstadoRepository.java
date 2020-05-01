package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.entity.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();

    Estado buscar(Long id);

    Estado salvar(Estado estado);

    void remover(Estado estado);
}
