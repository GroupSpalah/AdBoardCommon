package org.com.ad_board_common.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import lombok.Cleanup;

import static org.com.ad_board_common.util.ConstantsUtil.UNIT_NAME;

public interface CrudDAO<T> {

    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

    default void create(T obj) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(obj);

        transaction.commit();
    }

    void update(T obj);

    //    default T getById(Class<T> tClass, int id) {
    T getById(int id);

    void delete(T obj);
}
