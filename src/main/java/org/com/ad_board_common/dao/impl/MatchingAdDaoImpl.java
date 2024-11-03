package org.com.ad_board_common.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.MatchingAd;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class MatchingAdDaoImpl implements MatchingAdDAO { //SavedSearch

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

    @Override
    public void deleteAllAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_MADS_BY_AUTHOR, FK_MAD_AUTHOR, authorId);
    }

    @Override
    public void deleteAllAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_MADS_BY_HEADING, FK_MAD_HEADING, headingId);
    }
}
