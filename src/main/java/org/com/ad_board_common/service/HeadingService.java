package org.com.ad_board_common.service;

import org.com.ad_board_common.domain.Heading;

public interface HeadingService<T> {

    void createHeading(T obj);

    void updateHeading(T obj);

    T getHeadingById(int id);

    void deleteHeading(T obj);
}
