package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String name;

    @Column(name = "publication_date")
    LocalDate publicationDate;

    String content;

    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "FK_ad_heading")//создал heading_id
    Heading heading;

    @ManyToOne
    @JoinColumn(name = "FK_ad_author")
    Author author;
}
