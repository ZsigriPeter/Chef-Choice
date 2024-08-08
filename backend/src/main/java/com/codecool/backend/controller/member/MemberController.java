package com.codecool.backend.controller.member;

import com.codecool.backend.modell.dto.DTOMapper;
import com.codecool.backend.modell.dto.member.AddressDTO;
import com.codecool.backend.modell.dto.member.MemberDTO;
import com.codecool.backend.modell.dto.member.MemberLoginDTO;
import com.codecool.backend.modell.entity.member.Address;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.member.Role;
import com.codecool.backend.modell.payload.CreateNewMemberRequest;
import com.codecool.backend.modell.payload.JwtResponse;
import com.codecool.backend.modell.payload.MemberLoginRequest;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.RoleRepository;
import com.codecool.backend.security.jwt.JwtUtils;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api")
@RestController
public class MemberController {

    private final MemberService memberService;
    private final RoleRepository roleRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public MemberController(MemberService memberService, RoleRepository roleRepository, WebClient webClient, JwtUtils jwtUtils, AuthenticationManager authenticationManager, MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberService = memberService;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.authenticationManager = authenticationManager;
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/public/signup")
    public void signup(@RequestBody CreateNewMemberRequest createNewMemberRequest) {
        Address address = new Address(
                createNewMemberRequest.getStreetAndHouseNumber(),
                createNewMemberRequest.getSettlement(),
                createNewMemberRequest.getCountry(),
                createNewMemberRequest.getZIP()
        );
        Member member = new Member(
                createNewMemberRequest.getUsername(),
                passwordEncoder.encode(createNewMemberRequest.getPassword()),
                createNewMemberRequest.getEmail(),
                createNewMemberRequest.getFirstName(),
                createNewMemberRequest.getLastName(),
                createNewMemberRequest.getPhone(),
                address,
                Set.of(Objects.requireNonNull(roleRepository.findMemberRoleByRole(Role.ROLE_USER)).orElseThrow())
        );
        memberService.signUp(member);
    }

    @PostMapping("/public/login")
    public ResponseEntity<?> login(@RequestBody MemberLoginRequest memberLoginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(memberLoginRequest.getUsername(), memberLoginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);

        User userDetails = (User) authentication.getPrincipal();
        Set<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());

        return ResponseEntity.ok(new JwtResponse(token, userDetails.getUsername(), roles));
    }

    @GetMapping("/user/me")
    public MemberDTO getCurrentUser(@RequestHeader String Authorization) {
        String token = Authorization.substring(7);
        String username = jwtUtils.getUserNameFromJwtToken(token);
        Optional<Member> member = memberRepository.findUserByUsername(username);
        if (member.isPresent()) {
            Member member1 = member.get();
            return new MemberDTO(
                    member1.getUsername(),
                    member1.getEmail(),
                    member1.getFirstName(),
                    member1.getLastName(),
                    member1.getPhone(),
                    DTOMapper.toAddressDTO(member1.getAddress()),
                    DTOMapper.toMemberRoleDTOSet(member1.getRoles())
            );
        } else throw new MemberNotFoundException();
    }
}
