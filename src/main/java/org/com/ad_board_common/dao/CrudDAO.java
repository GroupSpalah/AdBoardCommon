package org.com.ad_board_common.dao;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.domain.Author;

import static org.com.ad_board_common.util.ConstantsUtil.UNIT_NAME;

public interface CrudDAO<T> {

    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

/*    default void create(T obj) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(obj);

        transaction.commit();
    }*/

    default void create(T obj) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(obj);

        transaction.commit();
}

    default void update(T obj) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(obj);

        transaction.commit();
    }

    default T getById(Class<T> tClass, int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        T entity = em.find(tClass, id);

//        TypedQuery<T> query = em.createQuery("FROM " + tClass.getSimpleName() + " obj WHERE obj.id := " + id, tClass);

        transaction.commit();

        return entity;
    }


    void delete(T obj);

}
