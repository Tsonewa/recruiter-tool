package com.example.recrutmenttool.exceptions;

public class SkillNotFoundExeption extends RuntimeException{

    private final Long id;

    public SkillNotFoundExeption(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Skill with id " + this.id + " does not exist!";
    }
}
