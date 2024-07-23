package com.codecool.backend.modell.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Address {

    @Id
    @GeneratedValue
    private long id;
    private String street;
    private int houseNumber;
    private String settlement;
    private String country;
    private int ZIP;
    @OneToMany(mappedBy = "address")
    private Set<Member> member;
}
