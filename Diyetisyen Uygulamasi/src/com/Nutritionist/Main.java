package com.Nutritionist;

import com.Nutritionist.Business.NutritionistManager;
import com.Nutritionist.Business.PatientManager;
import com.Nutritionist.Concretes.GreenworldDiet;
import com.Nutritionist.Concretes.ObeseDisease;
import com.Nutritionist.DataAccess.Concretes.FakeDataBaseDao;
import com.Nutritionist.Entities.Admin;
import com.Nutritionist.Entities.Nutritionist;
import com.Nutritionist.Entities.Patient;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static String authorization = "";
    public static String name = "";
    public static String surname = "";

    public static void login(String nId, String password) {
        FakeDataBaseDao fakeDataBaseDao = new FakeDataBaseDao();


        if (fakeDataBaseDao.loginAdmin(nId, password)) {
            authorization = "admin";
            System.out.println("Admin logged in, welcome.");
        } else if (fakeDataBaseDao.loginNutritionist(nId, password)) {
            authorization = "nutritionist";
            String[] nutr = fakeDataBaseDao.getNutritionist(nId);
            name = nutr[0];
            surname = nutr[1];
        } else {
            System.out.println("Login failed!");
        }
    }

    public static void screenClear() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {

        FakeDataBase.admins.add(new Admin("11111111111", "admin", "admin", "admin"));
        FakeDataBase.nutritionists.add(new Nutritionist("22222222222", "Berna", "Bayraktar", "berna"));
        FakeDataBase.nutritionists.add(new Nutritionist("33333333333", "Umut", "Altıntaş", "umut"));
        FakeDataBase.nutritionists.add(new Nutritionist("44444444444", "Utku", "Araal", "utku"));
        FakeDataBase.patients.add(new Patient("12312312312", "Halil", "Direktör", new ObeseDisease(), new GreenworldDiet(), "05.06.2021", "Berna", "Bayraktar"));


        Scanner myObj = new Scanner(System.in);


        boolean program = true;
        while (program) {
            while (authorization == "") {
                System.out.println("Welcome to Nutritionist app\n");
                System.out.println("Main Menu");
                System.out.println("1- Login");
                System.out.println("2- Quit");
                String choose = myObj.nextLine();

                if (choose.equals("1")) {
                    System.out.println("National Id : ");
                    String nId = myObj.nextLine();
                    System.out.println("Password : ");
                    String pass = myObj.nextLine();
                    System.out.println("Loggining in please wait a few seconds...");
                    TimeUnit.SECONDS.sleep(2);
                    login(nId, pass);
                    screenClear();
                } else if (choose.equals("2")) {
                    System.out.println("Exit...");
                    program = false;
                    break;
                } else {
                    System.out.println("Wrong choice!");
                }
            }

            if (authorization.equals("admin")) {
                NutritionistManager nutritionistManager = new NutritionistManager(new FakeDataBaseDao());
                while (authorization.equals("admin")) {
                    System.out.println("--------------------------");
                    System.out.println("1- Add Nutritionist");
                    System.out.println("q- Sign Out");
                    String chooseAdminMenu = myObj.nextLine();
                    if (chooseAdminMenu.equals("1")) {
                        System.out.println("National Id : ");
                        String nId = myObj.nextLine();
                        System.out.println("Name : ");
                        String name = myObj.nextLine();
                        System.out.println("Surname : ");
                        String surname = myObj.nextLine();
                        System.out.println("Password : ");
                        String pass = myObj.nextLine();
                        String[] informations = new String[]{nId, name, surname, pass};

                        nutritionistManager.add(informations);
                    } else if (chooseAdminMenu.equals("q")) {
                        authorization = "";
                    } else {
                        System.out.println("Wrong choose!");
                    }
                }


            } else if (authorization.equals("nutritionist")) {
                PatientManager patientManager = new PatientManager(new FakeDataBaseDao());
                System.out.println("Welcome to nutritionist system, " + name + " " + surname);
                System.out.println("--------------------------");
                System.out.println("1- Add Patient");
                System.out.println("2- Change a patient's diet");
                System.out.println("3- Get report");
                System.out.println("4- Show my patient list");
                System.out.println("q- Exit");
                String chooseNutrMenu = myObj.nextLine();
                if (chooseNutrMenu.equals("1")) {
                    System.out.println("National Id : ");
                    String nId = myObj.nextLine();
                    System.out.println("Name : ");
                    String nameP = myObj.nextLine();
                    System.out.println("Surname : ");
                    String surnameP = myObj.nextLine();
                    System.out.println("Disease name : ");
                    String disease = myObj.nextLine();
                    System.out.println("Diet type : ");
                    String diet = myObj.nextLine();
                    System.out.println("Diet start date : ");
                    String dietStartDate = myObj.nextLine();
                    patientManager.add(new String[]{nId, nameP, surnameP, disease, diet, dietStartDate, name, surname});
                } else if (chooseNutrMenu.equals("2")) {
                    System.out.println("National Id : ");
                    String nId = myObj.nextLine();
                    System.out.println("New diet type : ");
                    String diet = myObj.nextLine();
                    patientManager.changeDietType(name, surname, nId, diet);
                } else if (chooseNutrMenu.equals("3")) {
                    System.out.println("National Id : ");
                    String nId = myObj.nextLine();
                    System.out.println("Which format : ");
                    String reportType = myObj.nextLine();
                    System.out.println("1- Information - diet info");
                    System.out.println("2- Diet info - information");
                    int sort = myObj.nextInt();
                    patientManager.getReport(name, surname, nId, reportType, sort);
                    TimeUnit.SECONDS.sleep(2);
                } else if (chooseNutrMenu.equals("4")) {
                    patientManager.getMyPatientList(name, surname);
                    TimeUnit.SECONDS.sleep(2);
                } else if (chooseNutrMenu.equals("q")) {
                    authorization = "";
                    name = "";
                    surname = "";
                } else {
                    System.out.println("Wrong number!");
                }
            }
        }
    }
}
