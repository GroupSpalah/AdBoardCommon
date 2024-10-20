package org.com.ad_board_common;


import org.com.ad_board_common.dao.EmailDAO;
import org.com.ad_board_common.dao.impl.EmailDaoImpl;
import org.com.ad_board_common.domain.*;
import org.com.ad_board_common.service.AdService;
import org.com.ad_board_common.service.CrudService;
import org.com.ad_board_common.service.MatchingAdService;
import org.com.ad_board_common.service.impl.AdServiceImpl;
import org.com.ad_board_common.service.impl.AuthorServiceImpl;
import org.com.ad_board_common.service.impl.HeadingServiceImpl;
import org.com.ad_board_common.service.impl.MatchingAdServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AdBoardApp {
    public static void main(String[] args) {

        CrudService<Heading> headingCrudService = new HeadingServiceImpl();
        CrudService<Author> authorCrudService = new AuthorServiceImpl();
        AdService adService = new AdServiceImpl();
        MatchingAdService mAdService = new MatchingAdServiceImpl();


        Email johnEmail = Email
                .builder()
                //.id(1202)
                .email("john_travolta@gmail.com")
                .build();

        Email jackEmail = Email
                .builder()
                //.id(1202)
                .email("jack_nicholson@gmail.com")
                .build();

        Address johnAddress = Address
                .builder()
                //.id(602)
                .district("Columbia")
                .city("Washington")
                .street("20 avenue")
                .build();

        Address jackAddress = Address
                .builder()
                //.id(602)
                .district("Columbia")
                .city("Washington")
                .street("80 avenue")
                .build();

        Phone johnPhone = Phone
                .builder()
                //.id(402)
                .phoneNumber("0987654321")
                .build();
        Phone johnPhone2 = Phone
                .builder()
                //.id(403)
                .phoneNumber("0937654321")
                .build();
        Phone johnPhone3 = Phone
                .builder()
                //.id(404)
                .phoneNumber("0957654321")
                .build();

        Phone jackPhone = Phone
                .builder()
                //.id(402)
                .phoneNumber("0981234567")
                .build();
        Phone jackPhone2 = Phone
                .builder()
                //.id(403)
                .phoneNumber("0931234567")
                .build();
        Phone jackPhone3 = Phone
                .builder()
                //.id(404)
                .phoneNumber("0951234567")
                .build();

        Set<Phone> johnPhones = new HashSet<>();

        johnPhones.add(johnPhone);
        johnPhones.add(johnPhone2);
        johnPhones.add(johnPhone3);

        Set<Phone> jackPhones = new HashSet<>();

        jackPhones.add(jackPhone);
        jackPhones.add(jackPhone2);
        jackPhones.add(jackPhone3);

        Author john = Author
                .builder()
                .id(1)
                .firstName("John")
                .lastName("Travolta")
                .address(johnAddress)
                .email(johnEmail)
                .phones(johnPhones)
                .build();

        johnAddress.setAuthor(john);

        johnPhone.setAuthor(john);
        johnPhone2.setAuthor(john);
        johnPhone3.setAuthor(john);


        Author jack = Author
                .builder()
                .id(1)
                .firstName("Jack")
                .lastName("Nicholson")
                .address(jackAddress)
                .email(jackEmail)
                .phones(jackPhones)
                .build();

        jackAddress.setAuthor(jack);

        jackPhone.setAuthor(jack);
        jackPhone2.setAuthor(jack);
        jackPhone3.setAuthor(jack);


        Heading phonesHeading = Heading
                .builder()
                .id(1)
                .name("Phones")
                .build();

        Ad ad = Ad
                .builder()
                //.id(3)
                .heading(phonesHeading)
                .name("Sale Xiaomi 15")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(2000))
                .content("Selling Xiaomi 15")
                .author(john)
                .build();

        Ad ad2 = Ad
                .builder()
                .id(8)
                .heading(phonesHeading)
                .name("Sale IPhone 13")
                .publicationDate(LocalDate.now())
                .price(BigDecimal.valueOf(800))
                .content("Selling iPhone 13, NEW")
                .author(john)
                .isActive(false)//++
                .build();

        //headingCrudService.create(phonesHeading);//++
        //headingCrudService.delete(phonesHeading);//(with Ad & mAd)++
        //System.out.println(headingCrudService.getById(52).toString());//++

        //authorCrudService.create(john);//++
        //authorCrudService.create(jack);//++ (ок после взаимоисключения полей автора и адреса)
        //authorCrudService.update(john);//++

        /*проверить удаление с (mAd)*/
        //authorCrudService.delete(john);//(with Ad & mAd)++
        
        //adService.create(ad2);//++
        //adService.update(ad2);//++
        //adService.deleteInactiveAds();//++
        ///System.out.println(adService.getById(1));//++
        //adService.delete(ad);//++
        //System.out.println(adService.getAdsByHeadings(Collections.singletonList(2)));//++
        //System.out.println(adService.getAdsByHeadings(Arrays.asList(2, 52)));//++
        //System.out.println(adService.getAdsByPublicationDate(LocalDate.of(2024, 9, 28)));//++
        //System.out.println(adService.getAdsByAuthor(1152));//++
        //System.out.println(adService.getAdsByKeyword("new"));//++
        //System.out.println(john.getEmail());//??
        //System.out.println(john.getPhones());

        MatchingAd matchingAdJohn1 = MatchingAd.builder()
                .author(john)
                //.heading(phonesHeading)
                .subject("IPhone")
                //.priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1000))
                .build();

        MatchingAd matchingAdJack1 = MatchingAd.builder()
                .author(jack)
                .heading(phonesHeading)
                .subject("Xiaomi")
                .priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1000))
                .build();

        //mAdService.create(matchingAdJohn1);
        //mAdService.create(matchingAdJack1);



        //проверка обработки дубликатов
        //List с collect(Collectors.toUnmodifiableSet()) не убирает дубликаты


        MatchingAd matchingAdJohn2 = MatchingAd.builder()
                .id(4)
                .author(john)
                .heading(phonesHeading)
                .subject("IPhone")
                .priceFrom(BigDecimal.valueOf(0))
                .priceTo(BigDecimal.valueOf(1600))
                .build();
        //mAdService.create(matchingAdJohn2);++

        EmailDAO EMAIL_DAO = new EmailDaoImpl();


        //Set<Email> emails = EMAIL_DAO.findAllSuitableEmails(ad2);//++
        //System.out.println(emails);

        //mAdService.create(matchingAdJohn2);//работает с полным или частичным совпадением.
        //выводит результат по любому кол-ву установленных фильтров.

        //mAdService.delete(matchingAdJohn2);++
        //mAdService.update(matchingAdJohn2);//++
        //System.out.println(mAdService.getById(4));//++
    }
}
