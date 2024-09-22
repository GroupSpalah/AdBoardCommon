package org.com.ad_board_common.domain;

import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}/*, fetch = FetchType.EAGER*/)//?
    @JoinColumn(name = "FK_Author_Phone")
    Set<Phone> phones;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "author")
    Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "FK_Author_Email")
    Email email;
}
