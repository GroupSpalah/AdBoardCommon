package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data//изучить
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "matching_ad")//поменять в запросе
public class MatchingAd {

    @Id
    @Column(name = "mad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Mad_Heading")
    Heading heading;

    @Column(name = "price_from")
    BigDecimal priceFrom;

    @Column(name = "price_to")
    BigDecimal priceTo;

    String subject;

    @Version
    int version;
}
