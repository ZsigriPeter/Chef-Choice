package com.codecool.backend.controller;

public class DishAlreadyInDbException extends RuntimeException{
public DishAlreadyInDbException() {super("A dish with the same name is already in the database");}
}
