package org.com.ad_board_common.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.domain.*;
import org.jetbrains.annotations.NotNull;

import static org.com.ad_board_common.util.ConstantsUtil.*;

public class AuthorDaoImpl implements CrudDAO<Author> {
    @Override
    public void create(Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(author);//? merge/persist

        transaction.commit();
    }

    @Override
    public void update(@NotNull Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.merge(author);

        em.persist(author);

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
    public void delete(Author author) {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query deleteAd = em.createQuery(DELETE_AD_BY_AUTHOR);
        deleteAd.setParameter(FK_AD_AUTHOR, author.getId());


        Query deleteAuthor = em.createQuery(DELETE_AUTHOR);
        deleteAuthor.setParameter(AUTHOR_ID, author.getId());
        int deletedRows = deleteAuthor.executeUpdate();
        System.out.println("Rows deleted: " + deletedRows);
        transaction.commit();
    }
}
