package com.form3.payment.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.core.EntityInformation;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.io.Serializable;

@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private final EntityInformation entityInformation;
    private final EntityManager entityManager;
    private final EntityType<T> entityType;


    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {

        super(entityInformation, entityManager);

        this.entityInformation = entityInformation;
        this.entityManager = entityManager;
        this.entityType = entityManager.getMetamodel().entity(entityInformation.getJavaType());
    }


    @Override
    public T detachCopy(T entity) {
        entityManager.detach(entity);
        return entity;
    }


    @Override
    public T deleteAndFlush(T entity) {
        entityManager.remove(entity);
        entityManager.flush();
        return entity;
    }

    @Override
    public T persist(T model) {
        entityManager.persist(model);
        return model;
    }

    @Override
    public T persistAndFlush(T model) {
        persist(model);
        entityManager.flush();
        return model;
    }


}
