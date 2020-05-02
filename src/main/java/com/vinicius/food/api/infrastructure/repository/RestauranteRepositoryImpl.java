package com.vinicius.food.api.infrastructure.repository;

import com.vinicius.food.api.domain.model.Restaurante;
import com.vinicius.food.api.domain.repository.RestauranteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Restaurante> listar() {
        return entityManager.createQuery("from Restaurante", Restaurante.class)
                .getResultList();
    }

    @Override
    public Restaurante buscar(Long id) {
        return entityManager.find(Restaurante.class, id);
    }

    @Transactional
    @Override
    public Restaurante adicionar(Restaurante restaurante) {
        return entityManager.merge(restaurante);
    }

    @Transactional
    @Override
    public void remover(Restaurante restaurante) {
        restaurante = buscar(restaurante.getId());
        entityManager.remove(restaurante);
    }
}
