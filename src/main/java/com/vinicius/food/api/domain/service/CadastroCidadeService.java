package com.vinicius.food.api.domain.service;

import com.vinicius.food.api.domain.exception.EntidadeEmUsoException;
import com.vinicius.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.vinicius.food.api.domain.model.Cidade;
import com.vinicius.food.api.domain.model.Estado;
import com.vinicius.food.api.domain.repository.CidadeRepository;
import com.vinicius.food.api.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade adicionar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(estadoId);

        if (estado == null) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Nao existe cadastro de estado com codigo %d", estadoId));
        }

        cidade.setEstado(estado);

        return cidadeRepository.adicionar(cidade);
    }

    public void remover(Long id) {
        try {
            cidadeRepository.remover(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Nao existe um cadastro de cidade com codigo %d", id)
            );
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de codido %d nao pode ser removida, pois esta em uso\n", id)
            );
        }
    }
}
