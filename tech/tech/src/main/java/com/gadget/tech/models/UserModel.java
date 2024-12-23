package com.gadget.tech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Getter
    @Column(name = "phone_number", nullable = false, unique = true) // for keeping the name as it is in the db even if i change it here the name in tne db will still phone_number.
    private String phoneNumber;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private LocalDate birthday;

}
