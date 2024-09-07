package org.com.ad_board_common.dao;

public interface AdDao<T> {

    void createAd(T obj);

    void updateAd(T obj);

    T getAdById(int id);

    void deleteAd(T obj);
}
