package org.com.ad_board_common;


import org.com.ad_board_common.domain.*;
import org.com.ad_board_common.service.AdService;
import org.com.ad_board_common.service.CrudService;
import org.com.ad_board_common.service.impl.AdServiceImpl;
import org.com.ad_board_common.service.impl.AuthorServiceImpl;
import org.com.ad_board_common.service.impl.HeadingServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class AdBoardApp {
    public static void main(String[] args) {

        CrudService<Heading> headingCrudService = new HeadingServiceImpl();
        CrudService<Author> authorCrudService = new AuthorServiceImpl();
        AdService adService = new AdServiceImpl();

        Email johnEmail = Email
                .builder()
                //.id(1202)
                .email("john_travolta@gmail.com")
                .build();

        Address johnAddress = Address
                .builder()
                //.id(602)
                .district("Columbia")
                .city("Washington")
                .street("20 avenue")
                .build();

        Phone johnPhone = Phone
                .builder()
                //.id(402)
                .phoneNumber("0987654321")//не работает, передает NUll в поле автора
                .build();
        Phone johnPhone2 = Phone
                .builder()
                //.id(403)
                .phoneNumber("0937654321")//не работает, передает NUll в поле автора
                .build();
        Phone johnPhone3 = Phone
                .builder()
                //.id(404)
                .phoneNumber("0957654321")//не работает, передает NUll в поле автора
                .build();

        Set<Phone> phones = new HashSet<>();

        phones.add(johnPhone);
        phones.add(johnPhone2);
        phones.add(johnPhone3);

        Author john = Author
                .builder()
                //.id(1152)
                .firstName("John")
                .lastName("Travolta")
                .address(johnAddress)
                .email(johnEmail)
                .phones(phones)
                .build();

        johnAddress.setAuthor(john);

        johnPhone.setAuthor(john);
        johnPhone2.setAuthor(john);
        johnPhone3.setAuthor(john);

        Heading phonesHeading = Heading
                .builder()
                //.id(1)
                .name("Phones")
                .build();

        Ad ad = Ad
                .builder()
                //.id(602)
                .heading(phonesHeading)
                .name("Sale IPhone 16")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(999.99))
                .content("Selling iPhone 16, NEW")
                .author(john)
                .build();

        //headingCrudService.create(phonesHeading);//++
        //headingCrudService.delete(phonesHeading);//++
        //System.out.println(headingCrudService.getById(52).toString());//++

        //authorCrudService.create(john);//++
        //authorCrudService.update(john);//++
        //authorCrudService.delete(john);//(c Ad)++ не удаляет соответствующие автору телефоны и адреса
        //adService.create(ad);//++
        //adService.delete(ad);//++
        //System.out.println(adService.getAdsByHeadings(Collections.singletonList(2)));//++
        //System.out.println(adService.getAdsByHeadings(Arrays.asList(2, 52)));//++
        //System.out.println(adService.getAdsByPublicationDate(LocalDate.of(2024, 9, 28)));//++
        //System.out.println(adService.getAdsByAuthor(1152));//++
        //System.out.println(adService.getAdsByKeyword("new"));//++
        //System.out.println(john.getEmail());//??
        //System.out.println(john.getPhones());

    }
}