package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data//изучить
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DiscriminatorValue(value = "m_ad")
public class MatchingAd extends AbstractAd {

//@Table(name = "matching_ad")//поменять в запросе

/*    @Id
    @Column(name = "mad_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;*/

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
