package com.codecool.backend.controller.member;

public class MemberNotFoundException extends RuntimeException{
    public MemberNotFoundException(){
        super("Member not found");
    }
}
