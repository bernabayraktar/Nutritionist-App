package com.Nutritionist.Core.Concretes;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Core.Abstracts.ReportService;
import com.Nutritionist.Entities.Patient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JSONReportManager implements ReportService {
    @Override
    public String patientInformation(Patient patient) {
        try {
            JSONObject information = new JSONObject();
            information.put("NationalId", patient.getNationalIdentity());
            information.put("Name", patient.getName());
            information.put("Surname", patient.getSurname());
            information.put("DiseaseName", patient.getDiseaseName().getDiseaseName());
            information.put("DietType", patient.getDietType().getDietName());
            information.put("DietStartDate", patient.getDietStartDate());
            information.put("NutritionistName", patient.getNutritionistName());
            information.put("NutritionistSurname", patient.getNutritionistSurname());
            return information.toString();

        } catch (org.json.JSONException e) {
            System.out.println("An error occurred!");
            return "error 404 not found";
        }
    }

    @Override
    public String patientInformationAboutDiet(Diet diet) {
        try {
            JSONObject dietInfo = new JSONObject();
            JSONArray safeToEat = new JSONArray();
            JSONArray unsafeToEat = new JSONArray();

            for (String safe : diet.getSafeToEat()) {
                safeToEat.put(safe);
            }

            for (String unsafe : diet.getUnsafeToEat()) {
                unsafeToEat.put(unsafe);
            }

            dietInfo.put("SafeToEat", safeToEat);
            dietInfo.put("UnsafeToEat", unsafeToEat);

            return dietInfo.toString();
        } catch (org.json.JSONException e) {
            System.out.println("An error occurred!");
            return "error 404 not found";
        }
    }

    @Override
    public void createReport(Patient patient, int sortNumber) {
        String fileName = patient.getName() + patient.getSurname() + "Report.json";
        File jsonFile = new File(fileName);
        try {
            jsonFile.createNewFile();
            JSONParser parser = new JSONParser();
            String content = "";

            String information = patientInformation(patient);
            String dietInfo = patientInformationAboutDiet(patient.getDietType());


            if (sortNumber == 1) {
                content += """
                        { "Information" : 
                        """;
                content += information;
                content += """
                        ,                        
                        "DietInfo" : 
                        """;
                content += dietInfo;
                content += """
                        }
                        """;
            } else {
                content += """
                        { "DietInfo" : 
                        """;
                content += dietInfo;
                content += """
                        ,                        
                        "Information" : 
                        """;
                content += information;
                content += """
                        }
                        """;
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
