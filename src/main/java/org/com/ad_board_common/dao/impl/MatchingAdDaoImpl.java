package org.com.ad_board_common.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import lombok.Cleanup;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.MatchingAd;

import static org.com.ad_board_common.util.ConstantsUtil.*;

//Test all:--

public class MatchingAdDaoImpl implements MatchingAdDAO { //SavedSearch

    @Override
    public void create(MatchingAd mAd) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(mAd);

        transaction.commit();
    }

    @Override
    public void update(MatchingAd mAd) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(mAd);

        transaction.commit();
    }

    @Override
    public MatchingAd getById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd mAd = em.find(MatchingAd.class, id);
        transaction.commit();
        return mAd;
    }

    @Override
    public void delete(MatchingAd mAd) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd existingAd = em.find(MatchingAd.class, mAd.getId());

        em.remove(existingAd);

        transaction.commit();
    }

/*    @Override
    public void deleteAllAdByAuthorId(int authorId) {//объединить?
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_MADS_BY_AUTHOR);
        query.setParameter(FK_MAD_AUTHOR, authorId);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    @Override
    public void deleteAllAdByHeadingId(int headingId) {//объединить?
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_MADS_BY_HEADING);
        query.setParameter(FK_MAD_HEADING, headingId);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }*/

    //?

    @Override
    public void deleteAllAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_MADS_BY_AUTHOR, FK_MAD_AUTHOR, authorId);
    }

    @Override
    public void deleteAllAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_MADS_BY_HEADING, FK_MAD_HEADING, headingId);
    }

    private void deleteAllAdByParam(String request, String columnName, int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(request);
        query.setParameter(columnName, id);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }
}
