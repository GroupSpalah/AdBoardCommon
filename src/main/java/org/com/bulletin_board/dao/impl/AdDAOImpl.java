package org.com.bulletin_board.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.bulletin_board.dao.AdDAO;
import org.com.bulletin_board.db_connection.Requests;
import org.com.bulletin_board.domain.Ad;

public class AdDAOImpl implements AdDAO<Ad> {

    private EntityManager createEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(Requests.FACTORY_NAME);
        return factory.createEntityManager();
    }

    @Override
    public void add(Ad entity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(entity);

        transaction.commit();
    }

    @Override
    public Ad getById(int id) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        TypedQuery<Ad> query = em.createQuery(Requests.GET_BY_ID, Ad.class);

        query.setParameter(Requests.SET_ID, id);

        Ad ad = query.getSingleResult();

        System.out.println(ad);

        transaction.commit();

        return ad;
    }

    @Override
    public void update(Ad entity) {
        @Cleanup
        EntityManager em = createEntityManager();

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        Ad ad = em.merge(entity);

        em.persist(ad);

        transaction.commit();
    }
}
