package com.vinicius.food.api;

import com.vinicius.food.api.infrastructure.repository.spec.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class FoodApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodApiApplication.class, args);
    }

}
