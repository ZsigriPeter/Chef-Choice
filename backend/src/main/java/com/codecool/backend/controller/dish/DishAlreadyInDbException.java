package com.codecool.backend.controller.dish;

public class DishAlreadyInDbException extends RuntimeException{
public DishAlreadyInDbException() {super("A dish with the same name is already in the database");}
}
