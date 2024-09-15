package org.com.ad_board_common.dao.impl;


import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class HeadingDaoImpl implements CrudDAO<Heading> {
    @Override
    public void create(Heading heading) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(heading);

        transaction.commit();
    }

    @Override
    public void update(@NotNull Heading heading) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(heading);

        em.persist(heading);

        transaction.commit();
    }

    @Override
    public Heading getById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Heading heading = em.find(Heading.class, id);
        transaction.commit();
        return heading;
    }

    @Override
    public void delete(Heading heading) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query deleteAd = em.createQuery(DELETE_AD_BY_HEADING);
        deleteAd.setParameter(FK_AD_HEADING, heading.getId());

        TypedQuery<Heading> query = em.createQuery(DELETE_HEADING, Heading.class);
        query.setParameter(HEADING_ID, heading.getId());
        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }
}
