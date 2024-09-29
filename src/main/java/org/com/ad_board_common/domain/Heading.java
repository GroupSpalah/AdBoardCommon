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


public class Heading {

    @Id
    @Column(name = "heading_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;
}
