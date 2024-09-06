package com.codecool.backend.controller.dish;

public class NoSuchAllergenException extends RuntimeException{
    public NoSuchAllergenException() {super("Could not find allergen, please add allergen to database first.");}
}
