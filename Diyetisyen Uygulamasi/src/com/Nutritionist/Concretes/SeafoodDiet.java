package com.Nutritionist.Concretes;

import com.Nutritionist.Abstracts.Diet;

public class SeafoodDiet implements Diet {
    private String dietName = "Seafood diet";

    public String getDietName() {
        return dietName;
    }

    private String[] safeToEat = {
            "Seafood",
            "Fruits and vegetables",
            "Grains",
            "Dairy products and eggs"};

    public String[] getSafeToEat() {
        return safeToEat;
    }

    private String[] unsafeToEat = {
            "Red meat",
            "Poultry",
            "Pork",
            "Wild game"};

    public String[] getUnsafeToEat() {
        return unsafeToEat;
    }
}
