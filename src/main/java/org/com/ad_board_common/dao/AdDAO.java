package org.com.ad_board_common.dao;

import org.com.ad_board_common.domain.Ad;

import java.time.LocalDate;
import java.util.List;

public interface AdDAO {

    void deleteAllAdByAuthorId(int authorId);

    void deleteAllAdByHeadingId(int headingId);

    List<Ad> getAdsByHeadings(List<Integer> headingIds);

    List<Ad> getAdsByPublicationDate(LocalDate publicationDate);

    List<Ad> getAdsByAuthor(int authorId);
}
