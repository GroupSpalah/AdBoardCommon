package org.com.bulletin_board.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Cleanup;
import org.com.bulletin_board.db_connection.Requests;

public interface AdDAO<T> {

    void add(T entity);

    T getById(int id);

    void update(T entity);

}
