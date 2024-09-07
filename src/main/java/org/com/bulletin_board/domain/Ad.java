package org.com.bulletin_board.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"author", "rubric"})
@Builder

public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ad_id")
    int id;

    String name;

    LocalDate publicationDate;

    String adText;

    BigDecimal price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rubric_id")
    Rubric rubric;
}
