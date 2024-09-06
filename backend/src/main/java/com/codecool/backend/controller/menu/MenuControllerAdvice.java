package com.codecool.backend.controller.menu;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MenuControllerAdvice {
    @ResponseBody
    @ExceptionHandler(NoMenuForDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String noMenuForDateException(NoMenuForDateException ex) {
        return ex.getMessage();
    }
}
