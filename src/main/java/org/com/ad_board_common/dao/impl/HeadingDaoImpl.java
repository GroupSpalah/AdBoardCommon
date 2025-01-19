package org.com.ad_board_common.dao.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Repository("headingDaoImpl")
public class HeadingDaoImpl extends CrudDaoImpl<Heading> /*implements CrudDAO<Heading>*/ {

    final AdDAO AD_DAO;

    final MatchingAdDAO MATCHING_AD_DAO;

    public HeadingDaoImpl(AdDAO AD_DAO, MatchingAdDAO MATCHING_AD_DAO) {
        this.AD_DAO = AD_DAO;
        this.MATCHING_AD_DAO = MATCHING_AD_DAO;
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(@NotNull Heading heading) {

        Heading existingHeading = em.find(Heading.class, heading.getId());

        AD_DAO.deleteAllAdByHeadingId(existingHeading.getId());
        MATCHING_AD_DAO.deleteAllMAdByHeadingId(existingHeading.getId());

        em.remove(existingHeading);


    } // переделать на 1 запрос к базе вместо 2 find remove
}
