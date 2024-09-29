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
//@EqualsAndHashCode(exclude = "phones")
@NoArgsConstructor
@ToString(exclude = "phones")//для исключения StackOverflowError при выводе
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})

    @JoinColumn(name = "FK_Phone_Author")
    Set<Phone> phones;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "author")
    Address address;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_Author_Email")
    Email email;
}
