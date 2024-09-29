package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.dao.impl.MatchingAdDaoImpl;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.domain.MatchingAd;
import org.com.ad_board_common.service.MatchingAdService;

import java.math.BigDecimal;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class MatchingAdServiceImpl implements MatchingAdService {

    private MatchingAdDAO MATCHING_AD_DAO = new MatchingAdDaoImpl();

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
        return MATCHING_AD_DAO.getById(id);
    }

    @Override
    public void delete(MatchingAd matchingAd) {
        MATCHING_AD_DAO.delete(matchingAd);
    }

    @Override
    public void subscribeAuthorToAd(int authorId, Heading heading, BigDecimal priseFrom,
                                    BigDecimal priseTo, String wordToSearch) {
        MATCHING_AD_DAO.subscribeAuthorToAd(authorId, heading, priseFrom, priseTo, wordToSearch);
    }

}
