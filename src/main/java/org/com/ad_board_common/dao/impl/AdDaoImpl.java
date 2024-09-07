package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AdDao;
import org.com.ad_board_common.domain.Ad;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AdDaoImpl implements AdDao<Ad> {
    @Override
    public void createAd(Ad ad) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(ad);

        transaction.commit();
    }

    @Override
    public void updateAd(@NotNull Ad ad) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(UPDATE_AD);

        query.setParameter(NAME, ad.getName());
        query.setParameter(PUBLICATION_DATE, ad.getPublicationDate());
        query.setParameter(CONTENT, ad.getContent());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(HEADING, ad.getHeading());
        query.setParameter(AUTHOR, ad.getAuthor());
        query.setParameter(AD_ID, ad.getId());

        query.executeUpdate();

        transaction.commit();
    }

    @Override
    public Ad getAdById(int id) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Ad ad = em.find(Ad.class, id);
        transaction.commit();
        return ad;
    }

    @Override
    public void deleteAd(Ad ad) {

    }
}
