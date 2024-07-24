package com.codecool.backend.controller.dto;

public record NewMemberDTO(String email, String firstName, String lastName, String phone
        , String streetAndHouseNumber, String settlement, String country, int ZIP) {
}
