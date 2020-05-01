package com.vinicius.food.api.jpa;

import com.vinicius.food.api.FoodApiApplication;
import com.vinicius.food.api.domain.entity.Restaurante;
import com.vinicius.food.api.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoRestauranteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class);

        Restaurante restaurante1 = new Restaurante();
        restaurante1.setNome("Chão Goiano");

        Restaurante restaurante2 = new Restaurante();
        restaurante2.setNome("Comida Mineira");

        restaurante1 = restauranteRepository.adicionar(restaurante1);
        restaurante2 = restauranteRepository.adicionar(restaurante2);

        System.out.printf("%d - %s\n", restaurante1.getId(), restaurante1.getNome());
        System.out.printf("%d - %s\n", restaurante2.getId(), restaurante2.getNome());

    }
}
