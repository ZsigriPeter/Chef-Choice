package com.codecool.backend.modell.entity.order;

import com.codecool.backend.modell.entity.menu.MenuItem;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class PurchaseItem {

    @Id
    @GeneratedValue
    private Long id;
    private UUID publicId;
    private int quantity;
    @ManyToOne
    private MenuItem menuItem;

    public PurchaseItem(int quantity, MenuItem menuItem) {
        this.quantity = quantity;
        this.menuItem = menuItem;
        publicId = UUID.randomUUID();
    }

    public PurchaseItem() {}
}
