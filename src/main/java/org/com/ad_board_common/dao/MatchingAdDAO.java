package org.com.ad_board_common.dao;


import org.com.ad_board_common.domain.MatchingAd;

public interface MatchingAdDAO extends CrudDAO<MatchingAd> {

    void deleteAllAdByAuthorId(int authorId);

    void deleteAllAdByHeadingId(int authorId);
}
