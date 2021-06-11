package com.Nutritionist.Concretes;

import com.Nutritionist.Abstracts.Diet;

public class GlutenFreeDiet implements Diet {
    private String dietName = "Gluten free diet ";

    public String getDietName() {
        return dietName;
    }

    private String[] safeToEat = {
            "most dairy products, such as cheese, butter and milk",
            "fruit and vegetables",
            "meat and fish (although not breaded or battered)",
            "potatoes",
            "rice and rice noodles",
            "gluten-free flours, including rice, corn, soy and potato"};

    public String[] getSafeToEat() {
        return safeToEat;
    }

    private String[] unsafeToEat = {
            "bread",
            "pasta",
            "cereals",
            "biscuits or crackers",
            "cakes and pastries",
            "pies",
            "gravies and sauces"};

    public String[] getUnsafeToEat() {
        return unsafeToEat;
    }
}
