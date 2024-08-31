package org.com.bulletin_board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import lombok.Cleanup;

import java.util.Set;

public class BoardApp {
    public static void main(String[] args) {

        @Cleanup
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("bulletin_board");

        @Cleanup
        EntityManager em = factory.createEntityManager();

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
                .name("Serg")
                .email(email)
                .phoneNumbers(Set.of(phone))
                .build();

        address.setAuthor(author);
        phone.setAuthor(author);
        email.setAuthor(author);

        EntityTransaction transaction = em.getTransaction();

        transaction.begin();

        em.persist(author);

        transaction.commit();
    }
}
