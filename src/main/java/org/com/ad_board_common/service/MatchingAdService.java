package org.com.ad_board_common.service;

import org.com.ad_board_common.domain.MatchingAd;

/**
 * Service interface for managing matching ads and implementing business logic,
 * associated with matching announcements.
 * <p>
 * This interface provides methods to remove matching ads based on a specific parameter, for example:
 * <p>
 * - Removal of relevant ads by author or heading.
 * <p>
 * These methods use the DAO layer to access and modify the underlying data.
 */
public interface MatchingAdService extends CrudService<MatchingAd> {

/*    void deleteAllMAdByAuthorId(int authorId);

    void deleteAllMAdByHeadingId(int headingId);*/
}
