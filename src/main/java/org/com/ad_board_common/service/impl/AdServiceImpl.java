package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.service.AdService;

import java.time.LocalDate;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdServiceImpl implements AdService {

    AdDAO AD_DAO = new AdDaoImpl();
    //EmailDAO emailDao


    @Override
    public void create(Ad ad) {
        AD_DAO.create(ad);
        //emailDao.findAllSuitableEmails(ad);
    }

    @Override
    public void update(Ad ad) {
        AD_DAO.update(ad);
    }

    @Override
    public Ad getById(int id) {
        return AD_DAO.getById(id);
    }

    @Override
    public void delete(Ad ad) {
        AD_DAO.delete(ad);
    }

    @Override
    public void deleteAllAdByAuthorId(int authorId) {//объединить?
        AD_DAO.deleteAllAdByAuthorId(authorId);
    }

    @Override
    public void deleteAllAdByHeadingId(int authorId) {//объединить?
        AD_DAO.deleteAllAdByHeadingId(authorId);
    }

    @Override
    public List<Ad> getAdsByHeadings(List<Integer> headingIds) {
        return AD_DAO.getAdsByHeadings(headingIds);
    }

    @Override
    public List<Ad> getAdsByPublicationDate(LocalDate publicationDate) {
        return AD_DAO.getAdsByPublicationDate(publicationDate);
    }

    @Override
    public List<Ad> getAdsByAuthor(int authorId) {
        return AD_DAO.getAdsByAuthor(authorId);
    }

    @Override
    public List<Ad> getAdsByKeyword(String keyWord) {
        return AD_DAO.getAdsByKeyword(keyWord);
    }

}
