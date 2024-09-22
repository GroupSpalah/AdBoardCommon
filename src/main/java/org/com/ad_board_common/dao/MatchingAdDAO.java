package org.com.ad_board_common.dao;


import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.domain.MatchingAd;

import java.math.BigDecimal;

public interface MatchingAdDAO {

    void subscribeAuthorToAd(int authorId, Heading heading, BigDecimal priseFrom,
                             BigDecimal priseTo, String wordToSearch);

    //MatchingAd findAd(Heading heading, BigDecimal priseFrom,
    //                  BigDecimal priseTo, String wordToSearch);//?

}
