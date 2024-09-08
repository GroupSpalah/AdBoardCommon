package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.service.AdService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdServiceImpl implements AdService<Ad> {

    AdDao<Ad> AD_DAO = new AdDaoImpl();

    @Override
    public void createAd(Ad ad) {
        AD_DAO.createAd(ad);
    }

    @Override
    public void updateAd(Ad ad) {
        AD_DAO.updateAd(ad);

    }

    @Override
    public Ad getAdById(int id) {
        return AD_DAO.getAdById(id);
    }

    @Override
    public void deleteAd(Ad ad) {
        AD_DAO.deleteAd(ad);
    }
}
