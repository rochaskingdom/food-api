package com.vinicius.food.api.domain.service;

import com.vinicius.food.api.domain.exception.EntidadeNaoEncontradaException;
import com.vinicius.food.api.domain.model.Cozinha;
import com.vinicius.food.api.domain.model.Restaurante;
import com.vinicius.food.api.domain.repository.CozinhaRepository;
import com.vinicius.food.api.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;


    public Restaurante adicionar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.adicionar(restaurante);
    }
}
