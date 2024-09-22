package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.domain.Author;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AdDaoImpl implements AdDAO {

    @Override
    public void create(Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(ad);

        transaction.commit();
    }

    @Override
    public void update(@NotNull Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(ad);

        transaction.commit();
    }

    @Override
    public Ad getById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad ad = em.find(Ad.class, id);
        transaction.commit();
        return ad;
    }

    @Override
    public void delete(@NotNull Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad existingAd = em.find(Ad.class, ad.getId());

        em.remove(existingAd);

        transaction.commit();
    }

    @Override
    public void deleteAllAdByAuthorId(int authorId) {//объединить?
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_ADS_BY_AUTHOR);
        query.setParameter(FK_AD_AUTHOR, authorId);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    @Override
    public void deleteAllAdByHeadingId(int authorId) {//объединить?
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(DELETE_ADS_BY_HEADING);
        query.setParameter(FK_AD_HEADING, authorId);

        int deletedRows = query.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }

    @Override
    public List<Ad> getAdsByHeadings(List<Integer> headingIds) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();

        TypedQuery<Ad> query = em.createQuery(SELECT_ADS_BY_HEADINGS, Ad.class);
        query.setParameter(HEADING_IDS, headingIds);

        return query.getResultList();
    }

    @Override
    public List<Ad> getAdsByPublicationDate(LocalDate publicationDate) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();

        TypedQuery<Ad> query = em.createQuery(SELECT_ADS_BY_PUBLICATION_DATE, Ad.class);
        query.setParameter(PUBLICATION_DATE, publicationDate);

        return query.getResultList();
    }

    @Override
    public List<Ad> getAdsByAuthor(int authorId) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();

        TypedQuery<Ad> query = em.createQuery(SELECT_ADS_BY_AUTHOR_ID, Ad.class);
        query.setParameter(AUTHOR_ID, authorId);

        return query.getResultList();
    }
}
