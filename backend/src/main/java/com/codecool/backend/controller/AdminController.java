package com.codecool.backend.controller;

import com.codecool.backend.controller.dto.MemberAdminDTO;
import com.codecool.backend.modell.member.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private List<MemberAdminDTO> members = List.of(
            new MemberAdminDTO(1L, "member1"
                    , List.of("ROLE_USER","ROLE_ADMIN")),
            new MemberAdminDTO(2L, "member2"
                    , List.of("ROLE_USER"))
    );

    @GetMapping("/member")
    public List<MemberAdminDTO> getAllMembers() {
         return members;
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/member/add-admin/{id}")
    public ResponseEntity<?> addAdminRoleToMember(@PathVariable Long id) {
        MemberAdminDTO member =
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/member/remove-admin/{id}")
    public ResponseEntity<?> removeAdminRoleFromMember(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
