package com.codecool.backend.modell.entity.member;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Address {

    @Id
    @GeneratedValue
    private long id;
    private String streetAndHouseNumber;
    private String settlement;
    private String country;
    private int ZIP;

    public Address(String streetAndHouseNumber, String settlement, String country, int ZIP) {
        this.streetAndHouseNumber = streetAndHouseNumber;
        this.settlement = settlement;
        this.country = country;
        this.ZIP = ZIP;
    }

    public Address() {}

}
