package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.MatchingAd;
import org.com.ad_board_common.service.CrudService;
import org.springframework.stereotype.Service;

/**
 * The MatchingAdServiceImpl class is responsible for managing matching ads and handling related business logic.
 * Provides methods for CRUD operations on matching ads, as well as additional functions for matching ad management.
 * This class interacts with the DAO layer to perform these operations.
 */

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Service
public class MatchingAdServiceImpl implements CrudService<MatchingAd> {

    //MatchingAdDAO MATCHING_AD_DAO;

    CrudDAO<MatchingAd> MATCHING_AD_DAO;

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

}
