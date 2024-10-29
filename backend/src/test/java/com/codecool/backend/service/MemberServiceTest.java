package com.codecool.backend.service;

import com.codecool.backend.modell.dto.member.MemberToAdminPageDTO;
import com.codecool.backend.modell.entity.member.Member;
import com.codecool.backend.modell.entity.member.MemberRole;
import com.codecool.backend.modell.entity.member.Role;
import com.codecool.backend.repository.AddressRepository;
import com.codecool.backend.repository.MemberRepository;
import com.codecool.backend.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private AddressRepository addressRepository;

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private MemberService memberService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void signUp_ShouldSaveMemberAndAddress_WhenEmailDoesNotExist() {
        // Arrange
        Member member = new Member("johnDoe",1);
        when(memberRepository.findByEmail("johnDoe")).thenReturn(Optional.empty());

        // Act
        memberService.signUp(member);

        // Assert
        verify(addressRepository, times(1)).save(member.getAddress());
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void signUp_ShouldNotSaveMember_WhenEmailExists() {
        // Arrange
        Member existingMember = new Member("johnDoe",1);
        when(memberRepository.findByEmail("john@example.com")).thenReturn(Optional.of(existingMember));

        // Act
        memberService.signUp(existingMember);

        // Assert
        verify(addressRepository, never()).save(any());
        verify(memberRepository, never()).save(any());
    }

    @Test
    void getAllMembers_ShouldReturnMemberDTOList() {
        // Arrange
        Member member1 = new Member("johnDoe",1);
        Member member2 = new Member("janeDoe",2);
        when(memberRepository.findAll()).thenReturn(List.of(member1, member2));

        // Act
        List<MemberToAdminPageDTO> result = memberService.getAllMembers();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    void deleteMember_ShouldDeleteMember_WhenMemberExists() {
        // Arrange
        when(memberRepository.existsById(1L)).thenReturn(true);

        // Act
        memberService.deleteMember(1L);

        // Assert
        verify(memberRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteMember_ShouldThrowException_WhenMemberDoesNotExist() {
        // Arrange
        when(memberRepository.existsById(1L)).thenReturn(false);

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> memberService.deleteMember(1L));
    }

    @Test
    void addAdminRole_ShouldAddRole_WhenMemberExists() {
        // Arrange
        Member member = new Member("johnDoe",1);
        MemberRole adminRole = new MemberRole(Role.ROLE_ADMIN);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(roleRepository.findMemberRoleByRole(Role.ROLE_ADMIN)).thenReturn(Optional.of(adminRole));

        // Act
        memberService.addAdminRole(1L);

        // Assert
        assertTrue(member.getRoles().contains(adminRole));
        verify(memberRepository, times(1)).save(member);
    }

    @Test
    void addAdminRole_ShouldThrowException_WhenRoleDoesNotExist() {
        // Arrange
        Member member = new Member("johnDoe",1);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(roleRepository.findMemberRoleByRole(Role.ROLE_ADMIN)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> memberService.addAdminRole(1L));
    }

    @Test
    void removeAdminRole_ShouldThrowException_WhenRoleDoesNotExist() {
        // Arrange
        Member member = new Member("johnDoe",1);
        when(memberRepository.findById(1L)).thenReturn(Optional.of(member));
        when(roleRepository.findMemberRoleByRole(Role.ROLE_ADMIN)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> memberService.removeAdminRole(1L));
    }

    @Test
    void getMemberByUsername_ShouldReturnMember_WhenUsernameExists() {
        // Arrange
        Member member = new Member("johnDoe",1);
        when(memberRepository.findUserByUsername("johnDoe")).thenReturn(Optional.of(member));

        // Act
        Member result = memberService.getMemberByUsername("johnDoe");

        // Assert
        assertEquals("johnDoe", result.getUsername());
        verify(memberRepository, times(1)).findUserByUsername("johnDoe");
    }

    @Test
    void getMemberByUsername_ShouldThrowException_WhenUsernameDoesNotExist() {
        // Arrange
        when(memberRepository.findUserByUsername("johnDoe")).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NoSuchElementException.class, () -> memberService.getMemberByUsername("johnDoe"));
    }
}
