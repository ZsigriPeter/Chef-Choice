package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberLoginDTO;
import com.codecool.backend.controller.dto.NewMemberDTO;
import com.codecool.backend.modell.member.Address;
import com.codecool.backend.modell.member.Member;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private RestTemplateAutoConfiguration restTemplateAutoConfiguration;

    @PostMapping("/signup")
    public void signup(@RequestBody NewMemberDTO newMemberDTO) {
        Address address = new Address(newMemberDTO.streetAndHouseNumber(), newMemberDTO.settlement(), newMemberDTO.country(), newMemberDTO.ZIP());
        Member member = new Member(newMemberDTO.email(), newMemberDTO.firstName(), newMemberDTO.lastName(), newMemberDTO.phone(), address);
        memberService.signUp(member);
    }

    @PostMapping("/login")
    public NewMemberDTO login(@RequestBody MemberLoginDTO memberLoginDTO) {
        if (memberService.tryToLogIn(memberLoginDTO)==null) return null;
        return memberService.tryToLogIn(memberLoginDTO).toDTO();
    }
}
