package com.dera.World.Banking.domain.entities;

import com.dera.World.Banking.domain.enums.Roles;
//import com.dera.World.Banking.validations.ValidEmail;
import com.dera.World.Banking.validations.ValidEmail;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users_tbl")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserEntity extends BaseClass{

    private String firstName;

    private String middleName;

    private String lastName;

    private String phoneNumber;

    private String alternativePhoneNumber;

    @ValidEmail
    @Email(message = "Invalid email")
    private String email;

    private String password;

    private String stateOfOrigin;

    private String accountNumber;

    private BigDecimal accountBalance;

    private String address;

    private String profilePicture;

    private String gender;

    private String status;

    @Enumerated(EnumType.STRING)
    private Roles roles;
}
