package com.Nutritionist.DataAccess.Concretes;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.DataAccess.Abstracts.DataBaseDao;
import com.Nutritionist.Entities.Admin;
import com.Nutritionist.Entities.Nutritionist;
import com.Nutritionist.Entities.Patient;
import com.Nutritionist.FakeDataBase;

import java.util.ArrayList;
import java.util.List;


public class FakeDataBaseDao implements DataBaseDao {
    @Override
    public boolean loginAdmin(String nationalIdentity, String password) {
        for (Admin admin : FakeDataBase.admins) {
            if (admin.getNationalIdentity().equals(nationalIdentity) && admin.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean loginNutritionist(String userName, String password) {
        for (Nutritionist nutritionist : FakeDataBase.nutritionists) {
            if (nutritionist.getNationalIdentity().equals(userName) && nutritionist.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void addNutritionist(Nutritionist nutritionist) {
        FakeDataBase.nutritionists.add(nutritionist);
    }

    @Override
    public void addPatient(Patient patient) {
        FakeDataBase.patients.add(patient);
    }

    @Override
    public void changeDietList(String nationalId, Diet dietType) {
        for (Patient patient : FakeDataBase.patients) {
            if (patient.getNationalIdentity().equals(nationalId)) {
                patient.setDietType(dietType);
                return;
            }
        }
        System.out.println("Hatalı id girisi yapildi.");
    }

    @Override
    public boolean checkTcNutritionist(String id) {
        for (Nutritionist nutritionist : FakeDataBase.nutritionists) {
            if (nutritionist.getNationalIdentity().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean checkTcPatients(String tc) {
        for (Patient patient : FakeDataBase.patients) {
            if (patient.getNationalIdentity().equals(tc)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean chechNutritionistOfPatient(String name, String surname, String nationalId) {
        for (Patient patient : FakeDataBase.patients) {
            if (patient.getNationalIdentity().equals(nationalId) && patient.getNutritionistName().equals(name) && patient.getNutritionistSurname().equals(surname)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Patient getPatient(String nationalId) {
        for (Patient patient : FakeDataBase.patients) {
            if (patient.getNationalIdentity().equals(nationalId)) {
                return patient;
            }
        }
        return null;
    }

    @Override
    public String[] getNutritionist(String nationalId) {
        for (Nutritionist nutritionist : FakeDataBase.nutritionists) {
            if (nutritionist.getNationalIdentity().equals(nationalId)) {
                return new String[]{nutritionist.getName(), nutritionist.getSurname()};
            }
        }
        return null;
    }

    @Override
    public List<Patient> getMyPatientList(String name, String surname) {
        List<Patient> myPatients = new ArrayList<Patient>();
        for (Patient patient : FakeDataBase.patients) {
            if (patient.getNutritionistName().equals(name) && patient.getNutritionistSurname().equals(surname)) {
                myPatients.add(patient);
            }
        }
        return myPatients;
    }
}
