package org.com.ad_board_common.service;

public interface CrudService<T> {

    void create(T obj);

    void update(T obj);

    T getById(int id);

    void delete(T obj);
}
