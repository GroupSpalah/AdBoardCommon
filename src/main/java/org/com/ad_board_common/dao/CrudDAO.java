package org.com.ad_board_common.dao;

import javax.persistence.*;
import lombok.Cleanup;

import static org.com.ad_board_common.util.ConstantsUtil.UNIT_NAME;

/**
 * Interface {@code CrudDAO} is a general interface for CRUD operations (create, read, update, delete)
 * in the database for any entity type.
 * Uses ``DAO'' (Data Access Object) design pattern.
 * <p>
 * <b>Note.</b> This interface requires one {@code EntityManagerFactory} element
 * to manage the object manager lifecycle.
 *
 * @param <T> the entity type for which the DAO is implemented.
 */
public interface CrudDAO<T> {

    /**
     * Factory for instantiating {@code EntityManager} used for management
     * database operations. Uses the configuration name `UNIT_NAME`
     */
    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

    /**
     * Stores the new object in the database.
     *
     * @param obj an object of type {@code T} that is stored in the database.
     */
    default void create(T obj) {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(obj);

        transaction.commit();
    }

    /**
     * Updates an existing object in the database.
     *
     * @param obj an object of type {@code T} that is updated in the database.
     */
    default void update(T obj) {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(obj);

        transaction.commit();
    }

    /**
     * Returns the object by its identifier.
     *
     * @param tClass the class of the object to retrieve.
     * @param id     object identifier.
     * @return an object of type {@code T} corresponding to the given identifier.
     */
    default T getById(Class<T> tClass, int id) {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
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

    /**
     * Deletes all objects matching the specified conditions.
     *
     * @param request    the text of the request to delete objects.
     * @param columnName the name of the query parameter corresponding to the identifier.
     * @param id         the value of the identifier to search for objects to delete.
     */
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

    /**
     * Deletes a specific object from the database.
     *
     * @param obj an object of type {@code T} to be deleted from the database.
     * @throws IllegalArgumentException if {@code obj} is {@code null}.
     */
    void delete(T obj);

}
