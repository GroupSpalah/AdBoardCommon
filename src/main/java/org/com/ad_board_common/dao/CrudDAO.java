package org.com.ad_board_common.dao;

import jakarta.persistence.*;
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

        //T entity = em.find(tClass, id);

        String simpleName = tClass.getSimpleName();

        TypedQuery<T> query = em.createQuery("FROM " + simpleName + " WHERE id = :id", tClass);
        query.setParameter("id", id);

        T entity = query.getSingleResult();

        transaction.commit();

        return entity;
    }

    //test++
    default void deleteAllAdByParam(String request, String columnName, int id) {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(request);
        query.setParameter(columnName, id);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    void delete(T obj);

}
