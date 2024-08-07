package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.member.AddressDTO;
import com.codecool.backend.modell.dto.member.MemberAdminDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private List<MemberAdminDTO> members = List.of(
            new MemberAdminDTO(1L, "member1", "member1@email.com"
                    ,"John","Doe","+36 30 1234567"
                    ,new AddressDTO("Main Street 10","Budapest","Hungary",1051)
                    , Set.of("ROLE_USER","ROLE_ADMIN")),
            new MemberAdminDTO(2L, "member2", "member2@email.com"
                    ,"Mike","Smith","+36 70 1234567"
                    ,new AddressDTO("Main Street 12","Budapest","Hungary",1051)
                    , Set.of("ROLE_USER"))
    );

    @GetMapping("/member")
    public List<MemberAdminDTO> getAllMembers() {
         return members;
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/member/add-admin/{id}")
    public ResponseEntity<?> addAdminRoleToMember(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/member/remove-admin/{id}")
    public ResponseEntity<?> removeAdminRoleFromMember(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }
}
