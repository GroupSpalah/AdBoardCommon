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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "phone_number")
    String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "FK_Phone_Author", nullable = false)
    Author author;//? для заполнения null в FK_Phone_Author++
}