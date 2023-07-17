package com.nickprincy.vegassoccer.services;



import com.nickprincy.vegassoccer.model.Group;
import com.nickprincy.vegassoccer.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("**********************************");
        System.out.println("* Las Vegas Pickup Soccer Board! *");
        System.out.println("**********************************");
    }


    public void printHomePage() {
        System.out.println();
        System.out.println("1: View all pickup groups");
        System.out.println("2: Monday groups");
        System.out.println("3: Tuesday groups");
        System.out.println("4: Wednesday groups");
        System.out.println("5: Thursday groups");
        System.out.println("6: Friday groups");
        System.out.println("7: Saturday groups");
        System.out.println("8: Sunday groups");
        System.out.println("9: Select This option to register/modify a group");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }



    public void printMainMenu() {
        System.out.println();
        System.out.println("1: Add your group");
        System.out.println("0: Exit");
        System.out.println();
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }



    public Group promptForGroupData() {
        Group newgroup= new Group();

        String groupName = "";
        while (groupName.isBlank()) {
            groupName = promptForString("What is your group name?: ");
        }
        newgroup.setGroupName(groupName);

        String gameDay = "";
        while (gameDay.isBlank()) {
            gameDay= promptForString("On which day of the week you play?: ");
        }
        newgroup.setGameDay(gameDay);

        String startTime = "";
        while (startTime.isBlank()) {
            startTime = promptForString("What time do you start playing?:  ");
        }
        newgroup.setStartTime(startTime);

        String gameType = "";
        while (gameType.isBlank()) {
            gameType = promptForString("Does your group play Indoor or Outdoor?:  ");
        }
        newgroup.setGameType(gameType);


        String location = "";
        while (location.isBlank()) {
            location = promptForString("Where does your group play:  ");
        }
        newgroup.setLocation(location);

        String address = "";
        while (address.isBlank()) {
            address = promptForString("What is the address of the location you play?:  ");
        }
        newgroup.setAddress(address);

        String additionalInfo = "";
        additionalInfo = promptForString("Any additional information?:  ");

        newgroup.setAdditionalInfo(additionalInfo);

        return newgroup;
    }



    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

}
