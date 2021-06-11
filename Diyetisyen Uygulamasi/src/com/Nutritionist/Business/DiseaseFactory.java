package com.Nutritionist.Business;

import com.Nutritionist.Abstracts.Disease;
import com.Nutritionist.Concretes.CeliacDisease;
import com.Nutritionist.Concretes.DiabetesDisease;
import com.Nutritionist.Concretes.ObeseDisease;

public class DiseaseFactory {
    public Disease getDisease(String disease) {
        if (disease.equalsIgnoreCase("Obese Disease")) {
            return new ObeseDisease();
        } else if (disease.equalsIgnoreCase("Celiac Disease")) {
            return new CeliacDisease();
        } else if (disease.equalsIgnoreCase("Diabetes Disease")) {
            return new DiabetesDisease();
        } else {
            return null;
        }
    }
}
