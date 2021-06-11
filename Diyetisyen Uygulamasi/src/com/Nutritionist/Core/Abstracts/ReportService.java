package com.Nutritionist.Core.Abstracts;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Entities.Patient;

import java.io.IOException;

public interface ReportService {
    String patientInformation(Patient patient);

    String patientInformationAboutDiet(Diet diet);

    void createReport(Patient patient, int sortNumber) throws IOException;
}
