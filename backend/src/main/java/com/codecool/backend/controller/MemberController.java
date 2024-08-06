package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.MemberLoginDTO;
import com.codecool.backend.modell.dto.NewMemberDTO;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class MemberController {

    private final MemberService memberService;
    private WebClient webClient;

    @Autowired
    public MemberController(MemberService memberService, WebClient webClient) {
        this.memberService = memberService;
        this.webClient = webClient;
    }

    @PostMapping("/api/public/signup")
    public void signup(@RequestBody NewMemberDTO newMemberDTO) {
        /*Address address = new Address(newMemberDTO.streetAndHouseNumber(), newMemberDTO.settlement(), newMemberDTO.country(), newMemberDTO.ZIP());
        Member member = new Member(newMemberDTO.email(), newMemberDTO.firstName(), newMemberDTO.lastName(), newMemberDTO.phone(), address);
        memberService.signUp(member);*/
    }

    @PostMapping("/api/public/login")
    public NewMemberDTO login(@RequestBody MemberLoginDTO memberLoginDTO) {
        if (memberService.tryToLogIn(memberLoginDTO) == null) return null;
        return memberService.tryToLogIn(memberLoginDTO).toDTO();
    }
}
