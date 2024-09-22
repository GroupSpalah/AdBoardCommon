package org.com.ad_board_common.domain;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Objects;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode(exclude = "author")
@NoArgsConstructor
@ToString

public class Phone {

    @Id
    @Column(name = "phone_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "phone_number")
    String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "FK_Author_Phone", nullable = false)
    Author author;//? для заполнения null в FK_Author_Phone

}