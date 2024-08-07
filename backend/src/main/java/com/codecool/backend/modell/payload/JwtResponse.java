package com.codecool.backend.modell.payload;

import java.util.Set;

public record JwtResponse(String token, String username, Set<String> roles) {
}
