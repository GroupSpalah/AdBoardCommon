package org.com.ad_board_common.dao;

public interface AuthorDao<T> {

    void createAuthor(T obj);

    void updateAuthor(T obj);

    T getAuthorById(int id);

    void deleteAuthor(T obj);
}
