package com.codecool.backend.controller;

public class NoSuchAllergenException extends RuntimeException{
    public NoSuchAllergenException() {super("Could not find allergen, please add allergen to database first.");}
}
