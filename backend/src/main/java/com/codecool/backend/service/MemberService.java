package com.codecool.backend.service;

import com.codecool.backend.controller.dto.MemberLoginDTO;
import com.codecool.backend.repository.AddressRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.modell.member.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final AddressRepository addressRepository;

    public MemberService(MemberRepository memberRepository, AddressRepository addressRepository) {
        this.memberRepository = memberRepository;
        this.addressRepository = addressRepository;
    }

    public void signUp(Member member) {
        System.out.println(member);
        if (memberRepository.findByEmail(member.getEmail()).isEmpty()) {
            System.out.println("No Email match");
            addressRepository.save(member.getAddress());
            memberRepository.save(member);
        }
    }

    public Member tryToLogIn(MemberLoginDTO memberLoginDTO) {
        String email = memberLoginDTO.email();
        if (memberRepository.findByEmail(email).isEmpty()) {
            return null;
        }
        return memberRepository.findByEmail(email).get();
    }
}
