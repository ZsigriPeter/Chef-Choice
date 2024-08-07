package com.codecool.backend.modell.dto.member;

import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.member.MemberRole;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MemberDTOMapper {

    public static MemberAdminDTO toMemberAdminDTO(Member member) {
        return new MemberAdminDTO(
                member.getId(),
                member.getUsername(),
                member.getEmail(),
                member.getFirstName(),
                member.getLastName(),
                member.getPhone(),
                toAddressDTO(member.getAddress()),
                member.getRoles().stream()
                        .map(memberRole -> memberRole.getRole().name()).collect(Collectors.toSet())
        );
    }

    public static AddressDTO toAddressDTO(Address address) {
        return new AddressDTO(address.getStreetAndHouseNumber(),
                address.getSettlement(),
                address.getCountry(),
                address.getZIP());
    }

    public static Set<RoleDTO> toRoleDTOSet(Set<MemberRole> roles) {
        return roles.stream().map(role-> new RoleDTO(role.getRole().name()))
                .collect(Collectors.toSet());
    }
}
