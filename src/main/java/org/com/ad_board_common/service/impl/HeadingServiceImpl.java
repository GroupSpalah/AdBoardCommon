package org.com.ad_board_common.service.impl;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.impl.HeadingDaoImpl;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.service.CrudService;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class HeadingServiceImpl implements CrudService<Heading> {

    CrudDAO<Heading> HEADING_DAO = new HeadingDaoImpl();

    @Override
    public void create(Heading heading) {
        HEADING_DAO.create(heading);
    }

    @Override
    public void update(Heading heading) {
        HEADING_DAO.update(heading);
    }

    @Override
    public Heading getById(int id) {
        return HEADING_DAO.getById(id);
    }

    @Override
    public void delete(Heading heading) {
        HEADING_DAO.delete(heading);
    }
}
