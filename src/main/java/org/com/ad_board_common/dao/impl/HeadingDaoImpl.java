package org.com.ad_board_common.dao.impl;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class HeadingDaoImpl implements CrudDAO<Heading> {

    AdDAO AD_DAO = new AdDaoImpl();

    MatchingAdDAO MATCHING_AD_DAO = new MatchingAdDaoImpl();

    @Override
    public void delete(@NotNull Heading heading) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Heading existingHeading = em.find(Heading.class, heading.getId());

        AD_DAO.deleteAllAdByHeadingId(existingHeading.getId());
        MATCHING_AD_DAO.deleteAllAdByHeadingId(existingHeading.getId());

        em.remove(existingHeading);

        transaction.commit();
    }
}
