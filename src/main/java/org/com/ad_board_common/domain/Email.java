package org.com.ad_board_common.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Email {

    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "email_address")
    String emailAddress;
}
