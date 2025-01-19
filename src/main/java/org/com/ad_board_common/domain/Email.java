package org.com.ad_board_common.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue(value = "e_address")
public class Email extends AbstractEntity {

/*    @Id
    @Column(name = "email_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;*/ //закомментил для использования strategy @Inheritance(strategy = InheritanceType.SINGLE_TABLE)

    @Column(name = "email_address")
    String email;
}