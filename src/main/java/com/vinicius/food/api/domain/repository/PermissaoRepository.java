package com.vinicius.food.api.domain.repository;

import com.vinicius.food.api.domain.entity.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();

    Permissao buscar(Long id);

    Permissao salvar(Permissao permissao);

    void remover(Permissao permissao);
}
