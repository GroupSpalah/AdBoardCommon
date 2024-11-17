package org.com.ad_board_common.dao.impl;

import javax.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.MatchingAd;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import static org.com.ad_board_common.util.ConstantsUtil.*;
@Repository
public class MatchingAdDaoImpl implements MatchingAdDAO { //SavedSearch

    @Override
    public void delete(@NotNull MatchingAd mAd) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        MatchingAd existingAd = em.find(MatchingAd.class, mAd.getId());

        em.remove(existingAd);

        transaction.commit();
    }

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified author.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with author-specific values.
     *
     * @param authorId the ID of the author whose matching ads should be deleted
     */
    @Override
    public void deleteAllMAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_MADS_BY_AUTHOR, FK_MAD_AUTHOR, authorId);
    }

    /**
     * Deletes all {@link MatchingAd} entities associated with the specified heading.
     * This method uses a common parameterized deletion approach by invoking
     * {@code deleteAllAdByParam} with heading-specific values.
     *
     * @param headingId the ID of the heading whose matching ads should be deleted
     */
    @Override
    public void deleteAllMAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_MADS_BY_HEADING, FK_MAD_HEADING, headingId);
    }
}
