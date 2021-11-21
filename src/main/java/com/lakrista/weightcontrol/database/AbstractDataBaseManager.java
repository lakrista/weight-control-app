package com.lakrista.weightcontrol.database;

import lombok.Getter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import static javax.persistence.Persistence.createEntityManagerFactory;
import static lombok.AccessLevel.PROTECTED;

public abstract class AbstractDataBaseManager<T> {

    @Getter(PROTECTED)
    private final EntityManager entityManager;
    private final Class<T> persistentClass;

    public AbstractDataBaseManager(final String dbName) {
        EntityManagerFactory entityManagerFactory = createEntityManagerFactory(dbName + ".odb");
        entityManager = entityManagerFactory.createEntityManager();
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public void create(T t) {
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        entityManager.refresh(t);
    }

    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }

    public List<T> getAll() {
        return entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t").getResultList();
    }

    public abstract T get(Long id);
}
