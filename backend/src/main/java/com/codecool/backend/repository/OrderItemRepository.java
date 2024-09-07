package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.order.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<PurchaseItem, Long> {

}
