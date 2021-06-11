package com.Nutritionist.Business;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Abstracts.Disease;
import com.Nutritionist.Abstracts.ManagerService;
import com.Nutritionist.Core.Abstracts.ReportService;
import com.Nutritionist.Core.Concretes.HTMLReportManager;
import com.Nutritionist.Core.Concretes.JSONReportManager;
import com.Nutritionist.DataAccess.Abstracts.DataBaseDao;
import com.Nutritionist.Entities.Patient;

import java.io.IOException;
import java.util.List;

public class PatientManager implements ManagerService {
    private DataBaseDao dataBaseDao;
    private DiseaseFactory diseaseFactory = new DiseaseFactory();
    private DietFactory dietFactory = new DietFactory();


    public PatientManager(DataBaseDao dataBaseDao) {
        this.dataBaseDao = dataBaseDao;
    }

    @Override
    public void add(String[] informations) {
        for (String info : informations) {
            if (info == "") {
                System.out.println("This field cannot be left blank!");
                return;
            }
        }
        if (dataBaseDao.checkTcPatients(informations[0])) {
            System.out.println("The patient is allready registered.");
            return;
        }
        Disease disease = diseaseFactory.getDisease(informations[3]);
        Diet diet = dietFactory.getDiet(informations[4]);
        if (disease == null) {
            System.out.println("Such a disease type is not defined in the system.");
            return;
        } else if (diet == null) {
            System.out.println("Such a diet type is not defined in the system.");
            return;
        }
        Patient patient = new Patient(informations[0], informations[1], informations[2], disease, diet, informations[5], informations[6], informations[7]);
        dataBaseDao.addPatient(patient);
        System.out.println(informations[1] + " " + informations[2] + " saved successfuly.");
    }

    public void changeDietType(String name, String surname, String nationalId, String dietType) {
        if (!dataBaseDao.checkTcPatients(nationalId)) {
            System.out.println("The patient with this information is not registered.");
            return;
        } else if (!dataBaseDao.chechNutritionistOfPatient(name, surname, nationalId)) {
            System.out.println("This patient is not on your list.");
            return;
        } else {
            Diet diet = dietFactory.getDiet(dietType);
            if (diet == null) {
                System.out.println("Such a diet type is not defined in the system.");
                return;
            }
            dataBaseDao.changeDietList(nationalId, diet);
            System.out.println("Diet type changed.");
        }
    }

    public void getReport(String name, String surname, String nationalId, String reportType, int sortNumber) throws IOException {
        if (!dataBaseDao.checkTcPatients(nationalId)) {
            System.out.println("The patient with this information is not registered.");
            return;
        } else if (!dataBaseDao.chechNutritionistOfPatient(name, surname, nationalId)) {
            System.out.println("This patient is not on your list.");
            return;
        } else {
            Patient patient = dataBaseDao.getPatient(nationalId);
            ReportService reportService;
            if (reportType.equalsIgnoreCase("HTML")) {
                reportService = new HTMLReportManager();
            } else if (reportType.equalsIgnoreCase("JSON")) {
                reportService = new JSONReportManager();
            } else {
                System.out.println("System does not support this report type!");
                return;
            }
            reportService.createReport(patient, sortNumber);
            System.out.println("Report created successfully:)");
        }
    }

    public void getMyPatientList(String name, String surname) {
        List<Patient> patients = dataBaseDao.getMyPatientList(name, surname);
        int temp = 0;
        for (Patient patient : patients) {
            System.out.println("Name: " + patient.getName() + " " + patient.getSurname());
            System.out.println("National Id: " + patient.getNationalIdentity());
            System.out.println("Disease Name: " + patient.getDiseaseName().getDiseaseName());
            System.out.println("Diet Name: " + patient.getDietType().getDietName());
            System.out.println("Diet Start Date: " + patient.getDietStartDate());
            System.out.println("**********************************");
            temp++;
        }
        System.out.println("The number of patients on your list: " + temp);
    }
}

