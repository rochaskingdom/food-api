package com.vinicius.food.api.controller;

import com.vinicius.food.api.domain.entity.Cozinha;
import com.vinicius.food.api.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cozinhas") //, produces = MediaType.APPLICATION_JSON_VALUE)
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> lisar1() {
        System.out.println("LISTAR 1");
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public List<Cozinha> lisar2() {
        System.out.println("LISTAR 2");
        return cozinhaRepository.listar();
    }
}
