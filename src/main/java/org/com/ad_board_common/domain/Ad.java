package org.com.ad_board_common.domain;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data//изучить. Возможно использовать альтернативные аннотации
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(name = "is_active")
    boolean isActive;

    @Version
    int version;
}
