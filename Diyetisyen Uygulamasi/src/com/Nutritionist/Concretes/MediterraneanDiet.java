package com.Nutritionist.Concretes;

import com.Nutritionist.Abstracts.Diet;

public class MediterraneanDiet implements Diet {
    private String dietName = "Mediterranean diet";

    public String getDietName() {
        return dietName;
    }

    private String[] safeToEat = {
            "eat at least 5 portions of a variety of fruit and vegetables every day – find out more about getting your 5 A Day",
            "base your meals on starchy foods such as potatoes, bread, rice and pasta – choose wholegrain versions where possible",
            "eat some beans or pulses, fish, eggs, meat and other proteins (including 2 portions of fish every week, 1 of which should be oily)",
            "have some dairy or dairy alternatives (such as soya drinks) – choose lower-fat and lower-sugar options",
            "choose unsaturated oils and spreads, and eat in small amounts",
            "drink 6 to 8 glasses of fluid a day",
            "if consuming foods and drinks that are high in fat, salt or sugar, have them less often and in small amounts – find out more about reducing sugar in your diet"};

    public String[] getSafeToEat() {
        return safeToEat;
    }

    private String[] unsafeToEat = {
            "Red meats",
            "Sweets and other desserts",
            "Eggs",
            "Butter"};

    public String[] getUnsafeToEat() {
        return unsafeToEat;
    }
}
