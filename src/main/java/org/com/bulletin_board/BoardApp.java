package org.com.bulletin_board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import lombok.Cleanup;
import org.com.bulletin_board.db_connection.Requests;
import org.com.bulletin_board.domain.*;
import org.com.bulletin_board.service.impl.AdServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class BoardApp {
    public static void main(String[] args) {
        AdServiceImpl asi = new AdServiceImpl();

        Address address = Address
                .builder()
                .address("Symska av.")
                .build();

        Phone phone = Phone
                .builder()
                .number("+380971533280")
                .build();

        Email email = Email
                .builder()
                .email("serg@gmail.com")
                .build();

        Author author = Author
                .builder()
                .address(address)
                .firstName("Serg")
                .lastName("Khvostov")
                .email(email)
                .phoneNumbers(Set.of(phone))
                .build();

        address.setAuthor(author);
        phone.setAuthor(author);
        email.setAuthor(author);

        Rubric rubric = Rubric
                .builder()
                .name("Electronic items")
                .build();

        Ad ad = Ad
                .builder()
                .name("Sale TV")
                .publicationDate(LocalDate.of(2024, 8, 07))
                .adText("Xiaomi TV for sale in good condition.")
                .price(BigDecimal.valueOf(200))
                .author(author)
                .rubric(rubric)
                .build();

        //asi.addAd(ad);
        //asi.getAdById(1);

        /*Ad ad1 = asi.getAdById(1);
        ad1.setAdText("LG TV for sale in good condition.");
        asi.updateAd(ad1);*/


    }
}
