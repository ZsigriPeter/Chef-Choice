package com.codecool.backend.controller;

import com.codecool.backend.modell.dto.food.DishDTO;
import com.codecool.backend.modell.dto.member.MemberToAdminPageDTO;
import com.codecool.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private MemberService memberService;

    @Autowired
    public AdminController(MemberService memberService) {
        this.memberService = memberService;
    }

    //Member
    @GetMapping("/member/all")
    public List<MemberToAdminPageDTO> getAllMembers() {
        return memberService.getAllMembers();
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<?> updateMember(@PathVariable Long id) {
        //TODO return ResponseEntity.ok().build();
        throw new UnsupportedOperationException();
    }

    @DeleteMapping("/member/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @PatchMapping("/member/add-admin/{id}")
    public void addAdminRoleToMember(@PathVariable Long id) {
        memberService.addAdminRole(id);
    }

    @PatchMapping("/member/remove-admin/{id}")
    public void removeAdminRoleFromMember(@PathVariable Long id) {
        memberService.removeAdminRole(id);
    }

    //Dish
    @PostMapping("/dish")
    public void addNewDish(@RequestBody DishDTO dish) {

    }
}
