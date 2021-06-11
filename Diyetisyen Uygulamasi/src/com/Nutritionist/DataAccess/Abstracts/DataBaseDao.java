package com.Nutritionist.DataAccess.Abstracts;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Entities.Nutritionist;
import com.Nutritionist.Entities.Patient;

import java.util.List;

public interface DataBaseDao {
    boolean loginAdmin(String userName, String password);

    boolean loginNutritionist(String userName, String password);

    void addNutritionist(Nutritionist nutritionist);

    void addPatient(Patient patient);

    void changeDietList(String nationalId, Diet dietType);

    boolean checkTcNutritionist(String tc);

    boolean checkTcPatients(String tc);

    boolean chechNutritionistOfPatient(String name, String surname, String nationalId);

    Patient getPatient(String nationalId);

    String[] getNutritionist(String nationalId);

    List<Patient> getMyPatientList(String name, String surname);
}
