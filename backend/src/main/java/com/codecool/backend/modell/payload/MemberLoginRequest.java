package com.codecool.backend.modell.payload;

import lombok.Data;

@Data
public class MemberLoginRequest {
    private String username;
    private String password;
}
