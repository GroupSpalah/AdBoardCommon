package org.com.ad_board_common.dao.impl;


import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.HeadingDao;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class HeadingDaoImpl implements HeadingDao<Heading> {
    @Override
    public void createHeading(Heading heading) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(heading);

        transaction.commit();
    }

    @Override
    public void updateHeading(@NotNull Heading heading) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(UPDATE_HEADING);

        query.setParameter(NAME, heading.getName());
        query.setParameter(HEADING_ID, heading.getId());

        query.executeUpdate();

        transaction.commit();
    }

    @Override
    public Heading getHeadingById(int id) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Heading heading = em.find(Heading.class, id);
        transaction.commit();
        return heading;
    }

    @Override
    public void deleteHeading(Heading heading) {

    }
}
