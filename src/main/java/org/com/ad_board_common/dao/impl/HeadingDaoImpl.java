package org.com.ad_board_common.dao.impl;


import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;

public class HeadingDaoImpl implements CrudDAO<Heading> {

    private final AdDAO DAO = new AdDaoImpl();

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
    public void delete(@NotNull Heading heading) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Heading existingHeading = em.find(Heading.class, heading.getId());

        DAO.deleteAllAdByHeadingId(existingHeading.getId());

        em.remove(existingHeading);

        transaction.commit();
    }
}
