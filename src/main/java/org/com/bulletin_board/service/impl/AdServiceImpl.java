package org.com.bulletin_board.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.bulletin_board.dao.AdDAO;
import org.com.bulletin_board.dao.impl.AdDAOImpl;
import org.com.bulletin_board.domain.Ad;
import org.com.bulletin_board.service.AdService;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class AdServiceImpl implements AdService {

    AdDAO<Ad> daoAd;

    public AdServiceImpl() {
        daoAd = new AdDAOImpl();
    }

    @Override
    public void addAd(Ad ad) {
        daoAd.add(ad);
    }

    @Override
    public Ad getAdById(int id) {
        return daoAd.getById(id);
    }

    @Override
    public void updateAd(Ad newAd) {
        daoAd.update(newAd);
    }
}
