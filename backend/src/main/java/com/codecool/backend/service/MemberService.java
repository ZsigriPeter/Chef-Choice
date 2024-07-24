package com.codecool.backend.service;

import com.codecool.backend.repositrory.AddressRepository;
import com.codecool.backend.repositrory.MemberRepository;
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
}
