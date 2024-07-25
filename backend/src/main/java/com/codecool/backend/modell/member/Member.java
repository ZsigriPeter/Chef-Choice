package com.codecool.backend.modell.member;

import com.codecool.backend.controller.dto.NewMemberDTO;
import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @OneToOne
    private Address address;

    public Member(String email, String firstName, String lastName, String phone, Address address) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public Member() {}

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getPhone() {return phone;}

    public NewMemberDTO toDTO() {
        return new NewMemberDTO(
                email,
                firstName,
                lastName,
                phone,
                address.getStreetAndHouseNumber(),
                address.getSettlement(),
                address.getCountry(),
                address.getZIP()
        );
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + address +
                '}';
    }
}
