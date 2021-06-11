package com.Nutritionist.Entities;

import com.Nutritionist.Abstracts.Entity;

public class Admin implements Entity {

    private String nationalIdentity;
    private String name;
    private String surname;
    private String password;

    public Admin(String nationalIdentity, String name, String surname, String password) {
        this.nationalIdentity = nationalIdentity;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public String getNationalIdentity() {
        return nationalIdentity;
    }

    public void setNationalIdentity(String nationalIdentity) {
        this.nationalIdentity = nationalIdentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
