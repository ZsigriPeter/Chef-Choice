package com.codecool.backend.modell.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @ManyToOne
    private Address address;
}
