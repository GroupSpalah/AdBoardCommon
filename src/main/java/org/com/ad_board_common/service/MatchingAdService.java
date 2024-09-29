package org.com.ad_board_common.service;


import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.domain.MatchingAd;

import java.math.BigDecimal;

//delete
public interface MatchingAdService extends CrudDAO<MatchingAd> {

    void subscribeAuthorToAd(int authorId, Heading heading, BigDecimal priseFrom,
                             BigDecimal priseTo, String wordToSearch);

    //MatchingAd findAd(Heading heading, BigDecimal priseFrom,
    //                  BigDecimal priseTo, String wordToSearch);//?

}
