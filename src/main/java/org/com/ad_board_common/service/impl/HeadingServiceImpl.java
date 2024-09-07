package org.com.ad_board_common.service.impl;


import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.HeadingDao;
import org.com.ad_board_common.dao.impl.HeadingDaoImpl;
import org.com.ad_board_common.domain.Heading;
import org.com.ad_board_common.service.HeadingService;


@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class HeadingServiceImpl implements HeadingService<Heading> {

    HeadingDao<Heading> HEADING_DAO = new HeadingDaoImpl();

    @Override
    public void createHeading(Heading heading) {
        HEADING_DAO.createHeading(heading);
    }

    @Override
    public void updateHeading(Heading heading) {
        HEADING_DAO.updateHeading(heading);
    }

    @Override
    public Heading getHeadingById(int id) {
        return HEADING_DAO.getHeadingById(id);
    }

    @Override
    public void deleteHeading(Heading heading) {
        HEADING_DAO.deleteHeading(heading);
    }
}
