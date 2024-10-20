package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.EmailDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.dao.impl.EmailDaoImpl;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.domain.Email;
import org.com.ad_board_common.service.AdService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdServiceImpl implements AdService {

    EmailDAO EMAIL_DAO = new EmailDaoImpl();
    AdDAO AD_DAO = new AdDaoImpl();

    @Override
    public void create(Ad ad) {
        AD_DAO.create(ad);
        Set<Email> allSuitableEmails = EMAIL_DAO.findAllSuitableEmails(ad);
        System.out.println(allSuitableEmails);
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
    public void deleteAllAdByAuthorId(int authorId) {
        AD_DAO.deleteAllAdByAuthorId(authorId);
    }

    @Override
    public void deleteAllAdByHeadingId(int authorId) {
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

    public void deleteInactiveAds() {
        AD_DAO.deleteInactiveAds();
    }
}
