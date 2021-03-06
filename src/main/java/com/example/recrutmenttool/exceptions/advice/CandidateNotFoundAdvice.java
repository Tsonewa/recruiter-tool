package com.example.recrutmenttool.exceptions.advice;

import com.example.recrutmenttool.exceptions.CandidateNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CandidateNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(CandidateNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(CandidateNotFoundException ex) {
        return ex.getMessage();
    }
}
