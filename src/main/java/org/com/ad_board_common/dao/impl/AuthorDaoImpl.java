package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Cleanup;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.MatchingAdDAO;
import org.com.ad_board_common.domain.*;
import org.jetbrains.annotations.NotNull;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AuthorDaoImpl implements CrudDAO<Author> {

    AdDAO DAO = new AdDaoImpl();

    MatchingAdDAO MATCHING_AD_DAO = new MatchingAdDaoImpl();

    @Override
    public void create(Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(author);

        transaction.commit();
    }

    @Override
    public void update(@NotNull Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(author);

        transaction.commit();
    }

    @Override
    public Author getById(int id) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author author = em.find(Author.class, id);

        transaction.commit();

        return author;
    }

    @Override
    public void delete(@NotNull Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author existingAuthor = em.find(Author.class, author.getId());

        DAO.deleteAllAdByAuthorId(existingAuthor.getId());
        MATCHING_AD_DAO.deleteAllAdByAuthorId(existingAuthor.getId());

        Address authorAddress = existingAuthor.getAddress();

        if (authorAddress != null) {
            em.remove(authorAddress);
            existingAuthor.setAddress(null);
            em.merge(existingAuthor);
        }

        em.remove(existingAuthor);

        transaction.commit();
    }
}
