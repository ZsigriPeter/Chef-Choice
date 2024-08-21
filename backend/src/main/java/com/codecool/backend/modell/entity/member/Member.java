package com.codecool.backend.modell.entity.member;

import jakarta.persistence.*;
import lombok.Getter;

import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    private long id;
    private UUID publicId;
    @Column(unique = true)
    private String username;
    private String password;
    @Email
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

    public Member(String username, String password, String email, String firstName, String lastName, String phone, Address address, Set<MemberRole> roles) {
        this.publicId = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.roles = new HashSet<>(roles);
    }

    public Member() {
    }
}
