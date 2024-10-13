package org.com.ad_board_common.dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.com.ad_board_common.domain.Ad;
import org.com.ad_board_common.domain.Email;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static org.com.ad_board_common.util.ConstantsUtil.UNIT_NAME;

public interface EmailDAO {

    EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory(UNIT_NAME);

    Set<Email> findAllSuitableEmails(@NotNull Ad ad);
}
