package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Ad;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AdDaoImpl implements CrudDAO<Ad> {
    @Override
    public void create(Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(ad);

        transaction.commit();
    }

    @Override
    public void update(@NotNull Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(ad);

        em.persist(ad);

        transaction.commit();
    }

    @Override
    public Ad getById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad ad = em.find(Ad.class, id);
        transaction.commit();
        return ad;
    }

    @Override
    public void delete(Ad ad) { //int id?
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Ad> query = em.createQuery(DELETE_AD, Ad.class);
        query.setParameter(AD_ID, ad.getId());
        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }
}
