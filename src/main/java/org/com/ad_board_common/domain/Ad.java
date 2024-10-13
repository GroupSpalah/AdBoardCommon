package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.com.ad_board_common.dao.AdDAO;
import org.com.ad_board_common.dao.impl.AdDaoImpl;

import javax.swing.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Ad {

    @Id
    @Column(name = "ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    @Column(name = "publication_date")
    LocalDate publicationDate;

    String content;

    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Heading")
    Heading heading;

    @ManyToOne
    @JoinColumn(name = "FK_Ad_Author")
    Author author;

    @Column(name = "is_active"/*, columnDefinition = "BOOLEAN DEFAULT 1"*/)
    boolean isActive;//default 0 ?

    @PrePersist
    public void prePersist() {
        if (!this.isActive) {
            this.isActive = true;
        }
    }


    //для удаления при смене статуса на "не активно"
    //Exception in thread "main" org.hibernate.HibernateException: The internal connection pool has reached its maximum size and no connection is currently available

    /*    @PreUpdate
    @PrePersist
    public void checkStatus() {
        if (!this.isActive) {
            EntityManager em = AdDAO.FACTORY.createEntityManager();
            em.getTransaction().begin();
            Ad ad = em.contains(this) ? this : em.merge(this);
            em.remove(ad);
            em.getTransaction().commit();

            //AdDAO adDAO = new AdDaoImpl();
            //adDAO.delete(this);
        }
    }*/
}
