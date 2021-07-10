package com.lakrista.weightcontrol.database;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static lombok.AccessLevel.PROTECTED;

public abstract class AbstractDataBaseManager<T> {

    private EntityManagerFactory entityManagerFactory;
    @Getter(PROTECTED)
    private EntityManager entityManager;

    public AbstractDataBaseManager(String dbName) {
        entityManagerFactory = createEntityManagerFactory(dbName +".odb");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.refresh(t);//
    }

    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }

    public abstract T get(Long id);
}
