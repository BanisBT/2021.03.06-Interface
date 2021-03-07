package org.example;

import org.example.Exception.NoEmployerInDb;
import org.example.Modul.Employer;
import org.example.Service.EmployersDbManagerImpl;
import org.example.Service.LikesDeveloperManager;
import org.example.Service.LikesManagerImpl;
import org.example.Service.LikesManagersManager;

import java.util.Scanner;

import static org.example.Modul.EmployersRole.*;

/**
 * Hello world!
 */
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static App main = new App();
    private static EmployersDbManagerImpl employersDb = new EmployersDbManagerImpl();
    private static LikesManagerImpl likesManager = new LikesManagersManager();

    public static void main(String[] args) {

        String ivestis = "";

        while (!ivestis.equals("7")) {
            main.meniu();
            ivestis = sc.nextLine();

            switch (ivestis) {
                case "1":
                    main.addEmployer();
                    break;
                case "2":
                    main.giveLike();
                    break;
                case "3":
                    main.likesOfEmployer();
                    break;
                case "4":
                    System.out.println("Developer's is viso turi " + main.likesOfDevelopers() + " pagirimu");
                    break;
                case "5":
                    System.out.println("Developer's is viso turi " + main.likesOfManagers() + " pagirimu");
                    break;
                case "6":
                    System.out.println("Viso darbuotojai turi " + main.likesOfDevelopers() + main.likesOfManagers() + " pagirimu");
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Prasau pasirinkti is meniu");
                    break;
            }
        }

    }

    private void meniu() {
        System.out.println();
        System.out.println("[1] Uzregistruoti darbuotoja");
        System.out.println("[2] Duoti pagirima darbuotojui");
        System.out.println("[3] Kiek darbuotpjas turi pagirimu?");
        System.out.println("[4] Kiek pagirmu turi viso Developer's");
        System.out.println("[5] Kiek pagirmu turi viso Manager's");
        System.out.println("[6] Kiek pagirmu turi visi darbuotojei");
        System.out.println("[7] EXIT");
    }

    private void addEmployer() {
        System.out.println("Iveskite darbuotojo varda");
        String name = sc.nextLine();
        Employer employer = new Employer(name);
        String ivestis = "";

        while (!ivestis.equals("1") | !ivestis.equals("2") | !ivestis.equals("3") | !ivestis.equals("4")) {
            roleMeniu();
            ivestis = sc.nextLine();

            switch (ivestis) {
                case "1":
                    employer.setRole(PROJECT_MANAGER);
                    employersDb.addEmployerToDb(employer);
                    break;
                case "2":
                    employer.setRole(JUNIOR_DEVELOPER);
                    employersDb.addEmployerToDb(employer);
                    break;
                case "3":
                    employer.setRole(MILD_DEVELOPER);
                    employersDb.addEmployerToDb(employer);
                    break;
                case "4":
                    employer.setRole(SENIOR_DEVELOPER);
                    employersDb.addEmployerToDb(employer);
                    break;
                default:
                    System.out.println("Prasome pasirinkti pareigas is isvardintu sarase");
                    sc.nextLine();
                    break;
            }
        }
    }

    private void roleMeniu() {
        System.out.println("Kokios bus darbuotojo pareigos");
        System.out.println("[1] Project Manager");
        System.out.println("[2] Junior Developer");
        System.out.println("[3] Mild Developer");
        System.out.println("[4] Senior Developer");
    }

    private void giveLike() {
        System.out.println("Koki darbuotoje norite pagirti?");
        String name = sc.nextLine();
        try {
            likesManager.giveLike(name);
        } catch (NoEmployerInDb e) {
            System.out.println("Pagal pateikta varda darbuotojas nerastas");
            sc.nextLine();
        }
    }

    private void likesOfEmployer() {
        System.out.println("Kokio darbuotojo pagirimu skaiciu norite suzinoti");
        String name = sc.nextLine();
        try {
            System.out.println(likesManager.likesOfEmployer(name));
        } catch (NoEmployerInDb e) {
            System.out.println("Pagal pateikta varda darbuotojas nerastas");
            sc.nextLine();
        }
    }

    private int likesOfDevelopers() {
        LikesDeveloperManager likesDeveloperManager = new LikesDeveloperManager();
        return likesDeveloperManager.allLikesOfEmployers(employersDb.getEmployersDb());
    }

    private int likesOfManagers() {
        LikesManagersManager likesManagersManager = new LikesManagersManager();
        return likesManagersManager.allLikesOfEmployers(employersDb.getEmployersDb());
    }
}
