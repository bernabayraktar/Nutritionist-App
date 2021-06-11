package com.Nutritionist.Business;

import com.Nutritionist.Abstracts.ManagerService;
import com.Nutritionist.DataAccess.Abstracts.DataBaseDao;
import com.Nutritionist.Entities.Nutritionist;

public class NutritionistManager implements ManagerService {
    private DataBaseDao dataBaseDao;

    public NutritionistManager(DataBaseDao dataBaseDao) {
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
        if (dataBaseDao.checkTcNutritionist(informations[0])) {
            System.out.println("The nutritionist is allready registered.");
        } else {
            Nutritionist nutritionist = new Nutritionist(informations[0], informations[1], informations[2], informations[3]);
            dataBaseDao.addNutritionist(nutritionist);
            System.out.println("Nutritionist saved successfuly.");
        }
    }
}
