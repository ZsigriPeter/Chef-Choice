package com.codecool.backend.repository;

import com.codecool.backend.modell.entity.member.MemberRole;
import com.codecool.backend.modell.entity.member.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<MemberRole, Long> {

    Optional<MemberRole> findMemberRoleByRole(Role role);
}
