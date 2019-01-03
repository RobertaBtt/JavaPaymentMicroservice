package com.form3.payment.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    T detachCopy(T entity);

    T deleteAndFlush(T entity);

    T persist(T model);

    T persistAndFlush(T model);
}
