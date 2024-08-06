package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.member.MemberDTO;
import com.codecool.backend.modell.dto.member.MemberLoginDTO;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.member.Role;
import com.codecool.backend.modell.payload.CreateNewMemberRequest;
import com.codecool.backend.repository.RoleRepository;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;
import java.util.Set;

@RequestMapping("/api/public")
@RestController
public class MemberController {

    private final MemberService memberService;
    private final RoleRepository roleRepository;
    private final WebClient webClient;

    @Autowired
    public MemberController(MemberService memberService, RoleRepository roleRepository, WebClient webClient) {
        this.memberService = memberService;
        this.roleRepository = roleRepository;
        this.webClient = webClient;
    }

    @PostMapping("/signup")
    public void signup(@RequestBody CreateNewMemberRequest createNewMemberRequest) {
        Address address = new Address(createNewMemberRequest.getStreetAndHouseNumber(), createNewMemberRequest.getSettlement(), createNewMemberRequest.getCountry(), createNewMemberRequest.getZIP());
        Member member = new Member(createNewMemberRequest.getUsername(), createNewMemberRequest.getPassword(), createNewMemberRequest.getEmail()
                , createNewMemberRequest.getFirstName(), createNewMemberRequest.getLastName(), createNewMemberRequest.getPhone(), address
                , Set.of(Objects.requireNonNull(roleRepository.findMemberRoleByRole(Role.ROLE_USER)).orElseThrow()));
        memberService.signUp(member);
    }

    @PostMapping("/login")
    public MemberDTO login(@RequestBody MemberLoginDTO memberLoginDTO) {
        if (memberService.tryToLogIn(memberLoginDTO) == null) return null;
        return memberService.tryToLogIn(memberLoginDTO).toDTO();
    }
}
