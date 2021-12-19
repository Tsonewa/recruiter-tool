package com.example.recrutmenttool.models.bindings;

public class RecruiterBindingModel {

    private String lastName;
    private String email;
    private String country;

    public RecruiterBindingModel(String lastName, String email, String country) {
        this.lastName = lastName;
        this.email = email;
        this.country = country;
    }

    public RecruiterBindingModel() {
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
