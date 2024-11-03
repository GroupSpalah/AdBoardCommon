package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.domain.Ad;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AdDaoImpl implements AdDAO {

    @Override
    public void delete(@NotNull Ad ad) {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad existingAd = em.find(Ad.class, ad.getId());

        em.remove(existingAd);

        transaction.commit();
    }

    @Override
    public void deleteAllAdByAuthorId(int authorId) {
        deleteAllAdByParam(DELETE_ADS_BY_AUTHOR, FK_AD_AUTHOR, authorId);
    }

    @Override
    public void deleteAllAdByHeadingId(int headingId) {
        deleteAllAdByParam(DELETE_ADS_BY_HEADING, FK_AD_HEADING, headingId);
    }

    @Override
    public void deleteInactiveAds() {
        @Cleanup EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_INACTIVE_ADS);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    @Override
    public List<Ad> getAdsByHeadings(List<Integer> headingIds) {

        return getAdsByParam(SELECT_ADS_BY_HEADINGS, HEADING_IDS, headingIds);
    }

    @Override
    public List<Ad> getAdsByPublicationDate(LocalDate publicationDate) {

        return getAdsByParam(SELECT_ADS_BY_PUBLICATION_DATE, PUBLICATION_DATE, publicationDate);
    }

    @Override
    public List<Ad> getAdsByAuthor(int authorId) {

        return getAdsByParam(SELECT_ADS_BY_AUTHOR_ID, FK_AD_AUTHOR, authorId);
    }

    @Override
    public List<Ad> getAdsByKeyword(String keyWord) {

        return getAdsByParam(SELECT_ADS_BY_BY_KEYWORD, WORD, keyWord);
    }

    //вынести в интерфейс?
    //только если сделать getEntityByParam, но это не нужно по условию. Метод актуален только для Ad.
    private List<Ad> getAdsByParam(String request, String columnName, Object obj) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();

        TypedQuery<Ad> query = em.createQuery(request, Ad.class);
        query.setParameter(columnName, obj);

        return query.getResultList();
    }
}
