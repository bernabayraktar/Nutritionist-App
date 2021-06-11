package com.Nutritionist.Business;

import com.Nutritionist.Abstracts.Diet;
import com.Nutritionist.Concretes.GlutenFreeDiet;
import com.Nutritionist.Concretes.MediterraneanDiet;
import com.Nutritionist.Concretes.SeafoodDiet;

public class DietFactory {
    public Diet getDiet(String dietType) {
        if (dietType.equalsIgnoreCase("Gluten Free Diet")) {
            return new GlutenFreeDiet();
        } else if (dietType.equalsIgnoreCase("Mediterranean Diet")) {
            return new MediterraneanDiet();
        } else if (dietType.equalsIgnoreCase("Seafood Diet")) {
            return new SeafoodDiet();
        } else if (dietType.equalsIgnoreCase("Green World Diet")) {
            return new GlutenFreeDiet();
        } else {
            return null;
        }
    }
}
