package com.codecool.backend.modell.entity.member;

import com.codecool.backend.modell.dto.NewMemberDTO;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private long id;
    @GeneratedValue
    private long publicId;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    @OneToOne
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "members_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<MemberRole> roles;

    public Member(String username, String password, String email, String firstName, String lastName, String phone, Address address) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.roles = new HashSet<>();
    }

    public Member() {
    }


    public NewMemberDTO toDTO() {
        return new NewMemberDTO(
                username,
                email,
                firstName,
                lastName,
                phone,
                address.getStreetAndHouseNumber(),
                address.getSettlement(),
                address.getCountry(),
                address.getZIP(),
                roles
        );
    }
}
