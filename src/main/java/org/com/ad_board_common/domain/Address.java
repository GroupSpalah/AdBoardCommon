package org.com.ad_board_common.domain;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "author")
@DiscriminatorValue(value = "address")
public class Address extends AbstractEntity {//изменить на другой тип базы(видео 92) адрес и емейл - общее поле id, остальное оставить как было.

/*    @Id
    @Column(name = "address_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;*/ //закомментил для использования strategy @Inheritance(strategy = InheritanceType.SINGLE_TABLE)

    String district;

    String city;

    String street;

    @OneToOne
    @JoinColumn(name = "FK_Address_Author")
    @EqualsAndHashCode.Exclude
    Author author;
}