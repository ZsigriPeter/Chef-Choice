package com.codecool.backend.service;

import com.codecool.backend.modell.dto.member.MemberToAdminPageDTO;
import com.codecool.backend.modell.dto.member.MemberDTOMapper;
import com.codecool.backend.modell.entity.member.MemberRole;
import com.codecool.backend.modell.entity.member.Role;
import com.codecool.backend.repository.AddressRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;
    private final RoleRepository roleRepository;

    public MemberService(MemberRepository memberRepository, AddressRepository addressRepository, RoleRepository roleRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
        this.roleRepository = roleRepository;
    }

    public void signUp(Member member) {
        System.out.println(member);
        if (memberRepository.findByEmail(member.getEmail()).isEmpty()) {
            System.out.println("No Email match");
            addressRepository.save(member.getAddress());
            memberRepository.save(member);
        }
    }

/*    public Member tryToLogIn(MemberLoginDTO memberLoginDTO) {
        String username = memberLoginDTO.username();
        if (memberRepository.findByEmail(email).isEmpty()) {
            return null;
        }
        return memberRepository.findByEmail(email).get();
    }*/

    public List<MemberToAdminPageDTO> getAllMembers() {
        return memberRepository.findAll().stream()
                .map(MemberDTOMapper::toMemberAdminDTO).toList();
    }

    public void deleteMember(Long id) {
        if (memberRepository.existsById(id)) memberRepository.deleteById(id);
        else throw new NoSuchElementException("No such user."); // TODO ex.handling
    }

    public void addAdminRole(Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(); // TODO ex.handling

        MemberRole role = roleRepository.findMemberRoleByRole(Role.ROLE_ADMIN).orElseThrow(); // TODO ex.handling

        member.getRoles().add(role);
        memberRepository.save(member);
    }

    public void removeAdminRole(Long userId) {
        Member member = memberRepository.findById(userId).orElseThrow(); // TODO ex.handling

        MemberRole role = roleRepository.findMemberRoleByRole(Role.ROLE_ADMIN).orElseThrow(); // TODO ex.handling

        member.getRoles().remove(role);
        memberRepository.save(member);
    }
}
