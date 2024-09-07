package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.order.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Purchase, Long> {
    Optional<Purchase> findAllByMember(Member member);
}
