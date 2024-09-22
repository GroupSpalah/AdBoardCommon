package org.com.ad_board_common;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.CrudDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;
import org.com.ad_board_common.dao.impl.AuthorDaoImpl;
import org.com.ad_board_common.dao.impl.HeadingDaoImpl;
import org.com.ad_board_common.domain.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.com.ad_board_common.dao.CrudDAO.FACTORY;

public class AdBoardApp {
    public static void main(String[] args) {

        CrudDAO<Heading> headingDao = new HeadingDaoImpl();
        CrudDAO<Author> authorDao = new AuthorDaoImpl();
        CrudDAO<Ad> adDao = new AdDaoImpl();
        AdDAO adDao2 = new AdDaoImpl();

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
                //.id(502)
                .phoneNumber("0987654321")//не работает, передает NUll в поле автора
                .build();
        Phone johnPhone2 = Phone
                .builder()
                //.id(503)
                .phoneNumber("0937654321")//не работает, передает NUll в поле автора
                .build();
        Phone johnPhone3 = Phone
                .builder()
                //.id(504)
                .phoneNumber("0957654321")//не работает, передает NUll в поле автора
                .build();

        Set<Phone> phones = new HashSet<>();

        phones.add(johnPhone);
        phones.add(johnPhone2);
        phones.add(johnPhone3);

        Author john = Author
                .builder()
                .id(53)
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

        //@Cleanup
        //EntityManager em = FACTORY.createEntityManager();
        //Heading existingHeading = em.find(Heading.class, phonesHeading.getId());//без этого ссылается на временную сущность
        //Author existingAuthor = em.find(Author.class, john.getId());




        Ad ad = Ad
                .builder()
                .heading(phonesHeading)
                .name("Sale IPhone")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(999.99))
                .content("Selling iPhone 12, satisfactory condition, 70% battery, call for details.")
                .author(john)
                .build();


        //headingDao.create(phonesHeading);//++
        //headingDao.delete(phonesHeading);//++
        //System.out.println(headingDao.getById(52).toString());//++


        //System.out.println(johnPhone.getPhoneNumber());
        //authorDao.create(john);//++
        //authorDao.update(john);++
        //authorDao.delete(john);//(c Ad)++

/*        johnPhone.setAuthor(john);
        johnPhone2.setAuthor(john);
        johnPhone3.setAuthor(john);*/  //--

        //adDao.create(ad);//++
        //adDao.delete(ad);//++
        //System.out.println(adDao2.getAdsByHeadings(Collections.singletonList(2)));//++
        //System.out.println(adDao2.getAdsByHeadings(Arrays.asList(2, 52)));//++
        //System.out.println(adDao2.getAdsByPublicationDate(LocalDate.now()));//++
        //System.out.println(adDao2.getAdsByAuthor(53));//--


    }
}