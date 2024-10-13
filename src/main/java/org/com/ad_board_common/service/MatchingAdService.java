package org.com.ad_board_common.service;


import org.com.ad_board_common.domain.MatchingAd;

public interface MatchingAdService extends CrudService<MatchingAd> {

    void deleteAllAdByAuthorId(int authorId);

    void deleteAllAdByHeadingId(int headingId);
}
