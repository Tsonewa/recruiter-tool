package com.example.recrutmenttool.models.service;

public class RecruiterServiceModel {

    private String lastName;
    private String email;
    private String country;

    public RecruiterServiceModel() {
    }

    public RecruiterServiceModel(String lastName, String email, String country) {
        this.lastName = lastName;
        this.email = email;
        this.country = country;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
