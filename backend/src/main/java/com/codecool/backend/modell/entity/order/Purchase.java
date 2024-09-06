package com.codecool.backend.modell.entity.order;

import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Purchase {

    @Id
    @GeneratedValue
    private Long id;
    private UUID publicId;
    @ManyToOne
    private Member member;
    @OneToOne
    private Address address;
    @OneToMany
    private List<PurchaseItem> menuItems;

    public Purchase(Member member, Address address, List<PurchaseItem> purchaseItems) {
        this.member = member;
        this.address = address;
        this.menuItems = purchaseItems;
        publicId = UUID.randomUUID();
    }

    public Purchase() {
    }
}
