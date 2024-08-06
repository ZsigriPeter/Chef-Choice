package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class CreateNewMemberRequest {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String streetAndHouseNumber;
    private String settlement;
    private String country;
    private int ZIP;
}
