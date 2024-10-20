package org.com.ad_board_common.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.Cleanup;
import org.com.ad_board_common.dao.EmailDAO;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.domain.Email;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class EmailDaoImpl implements EmailDAO {

    @Override
    public Set<Email> findAllSuitableEmails(@NotNull Ad ad) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Email> query = em.createQuery(SELECT_MADS_BY_PARAMS, Email.class);
                                //mAd = Ad
        query.setParameter(HEADING_ID2, ad.getHeading().getId());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(CONTENT, ad.getContent());

        transaction.commit();
        return new HashSet<>(query.getResultList());
    }
}
