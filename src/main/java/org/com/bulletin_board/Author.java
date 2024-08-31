package org.com.bulletin_board;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Set;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id")
    int id;

    @OneToMany(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Set<Phone> phoneNumbers;

    @OneToOne(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Address address;

    String name;

    @OneToOne(mappedBy = "author", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    Email email;

}
