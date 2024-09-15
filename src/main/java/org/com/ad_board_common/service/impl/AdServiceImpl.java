package org.com.ad_board_common.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.service.CrudService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class AdServiceImpl implements CrudService<Ad> {

    CrudDAO<Ad> AD_DAO = new AdDaoImpl();

    @Override
    public void create(Ad ad) {
        AD_DAO.create(ad);
    }

    @Override
    public void update(Ad ad) {
        AD_DAO.update(ad);

    }

    @Override
    public Ad getById(int id) {
        return AD_DAO.getById(id);
    }

    @Override
    public void delete(Ad ad) {
        AD_DAO.delete(ad);
    }
}
