package com.example.recrutmenttool.exceptions.advice;

import com.example.recrutmenttool.exceptions.CandidateNotFoundException;
import com.example.recrutmenttool.exceptions.SkillNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class SkillNotFoundEAdvice {

    @ResponseBody
    @ExceptionHandler(SkillNotFoundExeption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(SkillNotFoundExeption ex) {
        return ex.getMessage();
    }
}
