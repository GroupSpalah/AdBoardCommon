package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.dao.impl.MatchingAdDaoImpl;
import org.com.ad_board_common.domain.MatchingAd;
import org.com.ad_board_common.service.MatchingAdService;

/**
 * The MatchingAdServiceImpl class is responsible for managing matching ads and handling related business logic.
 * Provides methods for CRUD operations on matching ads, as well as additional functions for matching ad management.
 * This class interacts with the DAO layer to perform these operations.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class MatchingAdServiceImpl implements MatchingAdService {

    MatchingAdDAO MATCHING_AD_DAO = new MatchingAdDaoImpl();

    @Override
    public void create(MatchingAd matchingAd) {
        MATCHING_AD_DAO.create(matchingAd);
    }

    @Override
    public void update(MatchingAd matchingAd) {
        MATCHING_AD_DAO.update(matchingAd);
    }

    @Override
    public MatchingAd getById(int id) {
        return MATCHING_AD_DAO.getById(MatchingAd.class, id);
    }

    @Override
    public void delete(MatchingAd matchingAd) {
        MATCHING_AD_DAO.delete(matchingAd);
    }

/*    @Override
    public void deleteAllMAdByAuthorId(int authorId) {
        MATCHING_AD_DAO.deleteAllMAdByAuthorId(authorId);
    }

    @Override
    public void deleteAllMAdByHeadingId(int headingId) {
        MATCHING_AD_DAO.deleteAllMAdByHeadingId(headingId);
    }*/
}
