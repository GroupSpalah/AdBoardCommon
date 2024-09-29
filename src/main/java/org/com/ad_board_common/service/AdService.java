package org.com.ad_board_common.service;

import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Ad;

import java.time.LocalDate;
import java.util.List;

public interface AdService extends CrudService<Ad> {

    void deleteAllAdByAuthorId(int authorId);

    void deleteAllAdByHeadingId(int headingId);

    List<Ad> getAdsByHeadings(List<Integer> headingIds);

    List<Ad> getAdsByPublicationDate(LocalDate publicationDate);

    List<Ad> getAdsByAuthor(int authorId);

    List<Ad> getAdsByKeyword(String keyWord);
}
