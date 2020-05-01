package com.vinicius.food.api.jpa;

import com.vinicius.food.api.FoodApiApplication;
import com.vinicius.food.api.domain.entity.Cidade;
import com.vinicius.food.api.domain.repository.CidadeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCidadeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(FoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);

        List<Cidade> todasCidades = cidadeRepository.listar();

        for (Cidade cidade : todasCidades) {
            System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
        }
    }

}

