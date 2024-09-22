package org.com.ad_board_common.dao.impl;

import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.domain.MatchingAd;

import java.math.BigDecimal;

public class MatchingAdDaoImpl implements CrudDAO<MatchingAd>, MatchingAdDAO {
    @Override
    public void create(MatchingAd obj) {

    }

    @Override
    public void update(MatchingAd obj) {

    }

    @Override
    public MatchingAd getById(int id) {
        return null;
    }

    @Override
    public void delete(MatchingAd obj) {

    }

    @Override
    public void subscribeAuthorToAd(int authorId, Heading heading, BigDecimal priseFrom,
                                    BigDecimal priseTo, String wordToSearch) {

    }
}
