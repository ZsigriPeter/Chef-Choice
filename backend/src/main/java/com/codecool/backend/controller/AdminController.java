package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberAdminDTO;
import com.codecool.backend.modell.member.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private MemberAdminDTO memberAdminDTO1 = new MemberAdminDTO(1L, "member1"
            , List.of("ROLE_USER","ROLE_ADMIN"));
    private MemberAdminDTO memberAdminDTO2 = new MemberAdminDTO(2L, "member2"
            , List.of("ROLE_USER"));

    @GetMapping("/member")
    public List<MemberAdminDTO> getAllMembers() {
         return List.of(memberAdminDTO1, memberAdminDTO2);
    }
}
