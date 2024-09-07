package org.com.bulletin_board.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"phoneNumbers", "address", "email"})
@Builder

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    int id;

    String firstName;

    String lastName;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Phone> phoneNumbers;

    @OneToOne(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Address address;

    @OneToOne(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Email email;

}
