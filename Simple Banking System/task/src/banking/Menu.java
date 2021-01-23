package banking;

import java.util.Scanner;
import java.util.Set;

public class Menu {
    public static void mainMenu(Scanner scanner, Set<Account> accounts) {
        MainMenu choice;
        while(true) {
            try {
                MainMenu.printMenu();
                choice = MainMenu.values()[Integer.parseInt(scanner.nextLine())];
                switch (choice) {
                    case NEW:
                        Account.createNewAccount(accounts);
                        break;
                    case LOGIN:
                        Account current = AuthManager.logIntoAccount(accounts, scanner);
                        if (current != null) {
                            System.out.println("\nYou have successfully logged in!\n");
                            accountMenu(scanner, current);
                        } else {
                            System.out.println("\nWrong card number or PIN!\n");
                        }
                        break;
                    case EXIT:
                        System.out.println("Bye!");
                        System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inappropriate input");
            }
        }
    }

    public static void accountMenu(Scanner scanner, Account account) {
        AccountMenu choice;
        while(true) {
            try {
                AccountMenu.printMenu();
                choice = AccountMenu.values()[Integer.parseInt(scanner.nextLine())];
                switch (choice) {
                    case BALANCE:
                        System.out.println("Balance: " + account.getBalance());;
                        break;
                    case LOGOUT:
                        System.out.println("You have successfully logged out");
                        return;
                    case EXIT:
                        System.out.println("Bye!");
                        System.exit(0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inappropriate input");
            }
        }
    }
}
