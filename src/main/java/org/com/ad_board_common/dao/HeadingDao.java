package org.com.ad_board_common.dao;

public interface HeadingDao<T> {

    void createHeading(T obj);

    void updateHeading(T obj);

    T getHeadingById(int id);

    void deleteHeading(T obj);
}
