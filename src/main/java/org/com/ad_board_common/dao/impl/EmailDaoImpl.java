package org.com.ad_board_common.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.com.ad_board_common.dao.EmailDAO;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.domain.Email;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

import static org.com.ad_board_common.util.ConstantsUtil.*;

@Repository
public class EmailDaoImpl implements EmailDAO {

    @PersistenceContext
    EntityManager em;

    @Override
    public Set<Email> findAllSuitableEmails(@NotNull Ad ad) {

/*        EntityTransaction transaction = em.getTransaction();
        transaction.begin()*/;

        TypedQuery<Email> query = em.createQuery(SELECT_MADS_BY_PARAMS, Email.class);
                                //mAd = Ad
        query.setParameter(HEADING_ID2, ad.getHeading().getId());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(PRICE, ad.getPrice());
        query.setParameter(CONTENT, ad.getContent());

        //transaction.commit();
        return new HashSet<>(query.getResultList());
    }
}
