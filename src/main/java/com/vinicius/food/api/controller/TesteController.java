package com.vinicius.food.api.controller;

import com.vinicius.food.api.domain.model.Cozinha;
import com.vinicius.food.api.domain.model.Restaurante;
import com.vinicius.food.api.domain.repository.CozinhaRepository;
import com.vinicius.food.api.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhaNome(@RequestParam("nome") String nome) {
        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/cozinhas/unico-por-nome")
    public Optional<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/cozinhas/exists")
    public boolean cozinhaExists(@RequestParam("nome") String nome) {
        return cozinhaRepository.existsByNome(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPorTaxaFrete(BigDecimal taxaInicial, BigDecimal taxaFinal) {
        return restauranteRepository.queryByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorNome(String nome, Long id) {
        return restauranteRepository.consultarPorNome(nome, id);
    }

    @GetMapping("/restaurantes/primeiro-por-nome")
    public Optional<Restaurante> restaurantePrimeiroPorNome(String nome) {
        return restauranteRepository.findFirstByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/top2-por-nome")
    public List<Restaurante> restaurantesTop2PorNome(String nome) {
        return restauranteRepository.findTop2ByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> restaurantesPorNomeFrete(String nome,
                                                      BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/count-por-cozinha")
    public int restaurantesCountPorCozinha(Long cozinhaId) {
        return restauranteRepository.countByCozinhaId(cozinhaId);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesPorNomeFrete(String nome) {

        return restauranteRepository.findComFreteGratis(nome);
    }

    @GetMapping("/restaurantes/primeiro")
    public Optional<Restaurante> restaurantePrimeiro() {

        return restauranteRepository.buscarPrimeiro();
    }

}
