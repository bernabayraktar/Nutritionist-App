package com.Nutritionist.Entities;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Abstracts.Disease;
import com.Nutritionist.Abstracts.Entity;

public class Patient implements Entity {
    private String nationalIdentity;
    private String name;
    private String surname;
    private Disease diseaseName;
    private Diet dietType;
    private String dietStartDate;
    private String nutritionistName;
    private String nutritionistSurname;

    public Patient(String nationalIdentity, String name, String surname, Disease diseaseName, Diet dietType, String dietStartDate, String nutritionistName, String nutritionistSurname) {
        this.nationalIdentity = nationalIdentity;
        this.name = name;
        this.surname = surname;

        this.diseaseName = diseaseName;
        this.dietType = dietType;
        this.dietStartDate = dietStartDate;
        this.nutritionistName = nutritionistName;
        this.nutritionistSurname = nutritionistSurname;
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

    public Disease getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(Disease diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Diet getDietType() {
        return dietType;
    }

    public void setDietType(Diet dietType) {
        this.dietType = dietType;
    }

    public String getDietStartDate() {
        return dietStartDate;
    }

    public void setDietStartDate(String dietStartDate) {
        this.dietStartDate = dietStartDate;
    }

    public String getNutritionistName() {
        return nutritionistName;
    }

    public void setNutritionistName(String nutritionistName) {
        this.nutritionistName = nutritionistName;
    }

    public String getNutritionistSurname() {
        return nutritionistSurname;
    }

    public void setNutritionistSurname(String nutritionistSurname) {
        this.nutritionistSurname = nutritionistSurname;
    }
}
