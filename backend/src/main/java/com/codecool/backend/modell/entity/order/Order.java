package com.codecool.backend.modell.entity.order;

import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.menu.MenuItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private UUID publicId;
    @ManyToOne
    private Member member;
    @OneToOne
    private Address address;
    @OneToMany
    private List<MenuItem> menuItems;


}
