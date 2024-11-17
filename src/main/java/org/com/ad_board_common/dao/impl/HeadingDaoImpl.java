package org.com.ad_board_common.dao.impl;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.Heading;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Repository
@Transactional
public class HeadingDaoImpl implements CrudDAO<Heading> {

    AdDAO AD_DAO;

    MatchingAdDAO MATCHING_AD_DAO;

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


    }
}
