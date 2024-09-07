package org.com.ad_board_common.service;

public interface AuthorService<T> {

    void createAuthor(T obj);

    void updateAuthor(T obj);

    T getAuthorById(int id);

    void deleteAuthor(T obj);
}
