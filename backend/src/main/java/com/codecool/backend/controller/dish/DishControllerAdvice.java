package com.codecool.backend.controller.dish;

import com.codecool.backend.controller.NoSuchAllergenException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DishControllerAdvice {

    @ResponseBody
    @ExceptionHandler(NoSuchAllergenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleNoSuchAllergenExceptionHandler(NoSuchAllergenException e) {return e.getMessage();}

    @ResponseBody
    @ExceptionHandler(DishAlreadyInDbException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleDishAlreadyInDbExceptionHandler(DishAlreadyInDbException e) {return e.getMessage();}
}
