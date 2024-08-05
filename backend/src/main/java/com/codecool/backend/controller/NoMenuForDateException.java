package com.codecool.backend.controller;

public class NoMenuForDateException extends RuntimeException{
    public NoMenuForDateException(){
        super("There is no menu for selected date");
    }
}
