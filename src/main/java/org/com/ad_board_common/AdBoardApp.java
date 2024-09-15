package org.com.ad_board_common;


import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.dao.impl.AuthorDaoImpl;
import org.com.ad_board_common.dao.impl.HeadingDaoImpl;
import org.com.ad_board_common.domain.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdBoardApp {
    public static void main(String[] args) {

        CrudDAO<Heading> headingDao = new HeadingDaoImpl();
        CrudDAO<Author> authorDao = new AuthorDaoImpl();
        CrudDAO<Ad> adDao = new AdDaoImpl();

        Email johnEmail = Email
                .builder()
                .emailAddress("john_dou@gmail.com")
                .build();

        Address johnAddress = Address
                .builder()
                .district("Columbia")
                .city("Washington")
                .street("20 avenue")
                .build();

        Phone johnPhone = Phone
                .builder()
                .phoneNumber("0987654321")
                .build();

        List<Phone> phones = new ArrayList<>();

        phones.add(johnPhone);

        Author john = Author
                .builder()
                .id(1)
                .firstName("John")
                .lastName("Dou")
                .address(johnAddress)//null
                .email(johnEmail)
                .phones(phones)
                .build();

        johnAddress.setAuthor(john);

        Heading phonesHeading = Heading
                .builder()
                .id(52)
                .name("Phones")
                .build();

        Ad ad = Ad
                .builder()
                .id(52)
                .heading(phonesHeading)
                .name("Sale IPhone")
                .price(BigDecimal.valueOf(999.99))
                .content("Selling iPhone 12, satisfactory condition, 70% battery, call for details.")
                .build();

        //headingDao.create(phonesHeading);
        //headingDao.delete(phonesHeading);
        //headingDao.getById(phonesHeading.getId());
        /**Cannot invoke "org.com.ad_board_common.domain.Heading.toString()" because the return value of "org.com.ad_board_common.dao.CrudDAO.getById(int)" is null
         at org.com.ad_board_common.AdBoardApp.main(AdBoardApp.java:69)
         */

        //authorDao.create(john);
        //authorDao.delete(john);

        //adDao.create(ad);
        //adDao.delete(ad);


    }
}
