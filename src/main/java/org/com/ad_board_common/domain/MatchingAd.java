package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Table(name = "matching_ad")
public class MatchingAd {

    @Id
    @Column(name = "matching_ad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_Matching_ad_Author")
    Author author;

    @ManyToOne
    @JoinColumn(name = "FK_Matching_ad_Heading")
    Heading heading;

    @Column(name = "price_from")
    BigDecimal priseFrom;

    @Column(name = "price_to")
    BigDecimal priseTo;

    String subject;
}

/**
 * Item - Mazda, priceFrom - 600, priceTo - 800, Rubric - Auto, Author - John
 * Item - Mazda, priceFrom - 600, priceTo - 800, Rubric - Auto, Author - Tom
 * <p>
 * MatchingAd{
 * <p>
 * Author - manyToOne
 * Rubric - manyToOne
 * BigDecimal priceFrom, priceTo
 * String subject
 * <p>
 * }
 */
