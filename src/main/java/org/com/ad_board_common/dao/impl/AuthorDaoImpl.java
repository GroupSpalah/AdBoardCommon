package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AuthorDao;
import org.com.ad_board_common.domain.*;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AuthorDaoImpl implements AuthorDao<Author> {
    @Override
    public void createAuthor(Author author) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(author);

        transaction.commit();
    }

    @Override
    public void updateAuthor(@NotNull Author author) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery(UPDATE_AUTHOR);

        query.setParameter(FIRST_NAME, author.getFirstName());
        query.setParameter(LAST_NAME, author.getLastName());
        query.setParameter(PHONES, author.getPhones());
        query.setParameter(ADDRESS, author.getAddress());
        query.setParameter(EMAIL, author.getEmail());
        query.setParameter(AUTHOR_ID, author.getId());

        query.executeUpdate();

        transaction.commit();
    }

    @Override
    public Author getAuthorById(int id) {
        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        @Cleanup
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Author author = em.find(Author.class, id);
        transaction.commit();
        return author;
    }

    @Override
    public void deleteAuthor(Author author) {

    }
}
