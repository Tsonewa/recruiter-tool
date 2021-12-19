package com.example.recrutmenttool.exceptions;

public class CandidateNotFoundException extends RuntimeException{

    private final Long id;

    public CandidateNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public String getMessage() {
        return "Candidate with id " + this.id + " does not exist!";
    }

}
