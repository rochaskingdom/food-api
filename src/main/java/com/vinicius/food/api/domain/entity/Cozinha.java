package com.vinicius.food.api.domain.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tab_cozinha")
public class Cozinha {

    @Id
    private Long id;

    private String nome;
}
