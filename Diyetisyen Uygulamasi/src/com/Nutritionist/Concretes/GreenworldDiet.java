package com.Nutritionist.Concretes;

import com.Nutritionist.Abstracts.Diet;

public class GreenworldDiet implements Diet {
    private String dietName = "Green world diet";

    public String getDietName() {
        return dietName;
    }

    private String[] safeToEat = {
            "eat at least 5 portions of a variety of fruit and vegetables every day",
            "base meals on potatoes, bread, rice, pasta or other starchy carbohydrates (choose wholegrain where possible)",
            "have some dairy alternatives, such as soya drinks and yoghurts (choose lower-fat and lower-sugar options)",
            "eat some beans, pulses and other proteins",
            "choose unsaturated oils and spreads, and eat in small amounts",
            "gluten-free flours, including rice, corn, soy and potato",
            "drink plenty of fluids (the government recommends 6 to 8 cups or glasses a day)"};

    public String[] getSafeToEat() {
        return safeToEat;
    }

    private String[] unsafeToEat = {
            "Beef, pork, lamb, and other red meat",
            "Chicken, duck, and other poultry",
            " Fish or shellfish such as crabs, clams, and mussels",
            "Eggs",
            "Cheese, butter",
            "Milk, cream, ice cream, and other dairy products",
            "Mayonnaise (because it includes egg yolks)",
            "honey "};

    public String[] getUnsafeToEat() {
        return unsafeToEat;
    }
}
