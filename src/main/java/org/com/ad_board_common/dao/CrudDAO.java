package org.com.ad_board_common.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import static org.com.ad_board_common.util.ConstantsUtil.UNIT_NAME;

public interface CrudDAO<T> {
    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

    void create(T obj);

    void update(T obj);

    T getById(int id);

    void delete(T obj);
}
