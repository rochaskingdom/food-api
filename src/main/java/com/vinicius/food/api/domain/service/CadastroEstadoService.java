package com.vinicius.food.api.domain.service;

import com.vinicius.food.api.domain.exception.EntidadeEmUsoException;
import com.vinicius.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.vinicius.food.api.domain.model.Estado;
import com.vinicius.food.api.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void remover(Long id) {
        try {
            estadoRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Nao existe um cadastro de estado com codigo %d", id));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Estado de codigo %d nao pode ser removido, pois esta em uso", id)
            );
        }
    }
}
