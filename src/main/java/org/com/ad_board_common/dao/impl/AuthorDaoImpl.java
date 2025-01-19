package org.com.ad_board_common.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.Address;
import org.com.ad_board_common.domain.Author;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@FieldDefaults(level = AccessLevel.PRIVATE/*, makeFinal = true*/)
@Repository("authorDaoImpl")
@Transactional
public class AuthorDaoImpl extends CrudDaoImpl<Author> /*implements CrudDAO<Author>*/ {

    final AdDAO DAO;

    final MatchingAdDAO MATCHING_AD_DAO;

    public AuthorDaoImpl(AdDAO DAO, MatchingAdDAO MATCHING_AD_DAO) {
        this.DAO = DAO;
        this.MATCHING_AD_DAO = MATCHING_AD_DAO;
    }

    @PersistenceContext
    EntityManager em;

    @Override
    public void delete(@NotNull Author author) {

        Author existingAuthor = em.find(Author.class, author.getId());

        DAO.deleteAllAdByAuthorId(existingAuthor.getId());
        MATCHING_AD_DAO.deleteAllMAdByAuthorId(existingAuthor.getId());

        Address authorAddress = existingAuthor.getAddress();

        if (authorAddress != null) {
            em.remove(authorAddress);
            existingAuthor.setAddress(null);
            em.merge(existingAuthor);
        }

        em.remove(existingAuthor);
    }
}
