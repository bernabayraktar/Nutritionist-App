package com.Nutritionist.Core.Concretes;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Core.Abstracts.ReportService;
import com.Nutritionist.Entities.Patient;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HTMLReportManager implements ReportService {
    @Override
    public String patientInformation(Patient patient) {
        String information =

                "<div style=\"float:left; margin-left: 100px;\">\n" +
                        "<h3>National ID: " + patient.getNationalIdentity() + "</h3><br>\n" +
                        "<h3>Name surname: " + patient.getName() + " " + patient.getSurname() + "</h3><br>\n" +
                        "<h3>Disease name: " + patient.getDiseaseName().getDiseaseName() + "</h3><br>\n" +
                        "</div>\n" +
                        "<div style=\"float: right; margin-right: 100px;\">\n" +
                        "<h3>Diet Type: " + patient.getDietType().getDietName() + "</h3><br>\n" +
                        "<h3>Diet start date: " + patient.getDietStartDate() + "</h3><br>\n" +
                        "<h3>Nutritionist name: " + patient.getNutritionistName() + " " + patient.getNutritionistSurname() + "</h3><br>\n" +
                        "</div>\n" +
                        "<div style=\"clear: both;\"></div>\n";

        return information;
    }

    @Override
    public String patientInformationAboutDiet(Diet diet) {
        String dietInfo = "<div style= \"margin-left: 50px;\">\n" +
                "<h2>Safe to eat</h2>\n" +
                "<ul>";
        for (String safe : diet.getSafeToEat()) {
            dietInfo += "<li>" + safe + "</li>";
        }
        dietInfo += "</ul>\n" +
                "<br><br><br>\n" +
                "<h2>Unsafe to eat</h2>\n" +
                "<ul>";
        for (String unsafe : diet.getUnsafeToEat()) {
            dietInfo += "<li>" + unsafe + "</li>";
        }
        dietInfo += "</ul>\n" +
                "</div>";

        return dietInfo;
    }


    @Override
    public void createReport(Patient patient, int sortNumber) {
        String fileName = patient.getName() + patient.getSurname() + "Report.html";
        File htmlFile = new File(fileName);
        try {
            htmlFile.createNewFile();
            String content = "<h1 style=\"text-align: center;\">Patient Report</h1><br><br><br>\n";
            String information = patientInformation(patient);
            String dietInfo = patientInformationAboutDiet(patient.getDietType());
            if (sortNumber == 1) {
                content += information;
                content += "<hr>";
                content += dietInfo;
            } else {
                content += dietInfo;
                content += "<hr>";
                content += information;
            }

            FileWriter fileWriter = new FileWriter(fileName, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(content);
            bWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while generating the report.");
        }
    }
}
