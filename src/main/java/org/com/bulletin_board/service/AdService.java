package org.com.bulletin_board.service;

import org.com.bulletin_board.domain.Ad;

public interface AdService {

    void addAd(Ad ad);

    Ad getAdById(int id);

    void updateAd(Ad newAd);


}
