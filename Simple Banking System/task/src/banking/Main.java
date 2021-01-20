package banking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        MainMenu choice;

        while(true) {
            try {
                MainMenu.printMenu();
                choice = MainMenu.values()[Integer.parseInt(scanner.nextLine())];
                switch (choice) {
                    case NEW:
                        createNewAccount(accounts);
                        break;
                    case LOGIN:
                        if (logIntoAccount(accounts, scanner)) {
                            System.out.println("\nYou have successfully logged in!\n");
                            accountMenu(scanner);
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

    public static void accountMenu(Scanner scanner) {
        AccountMenu choice;
        while(true) {
            try {
                AccountMenu.printMenu();
                choice = AccountMenu.values()[Integer.parseInt(scanner.nextLine())];
                switch (choice) {
                    case BALANCE:
                        System.out.println("Balance: 0");;
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

    public static void createNewAccount(List<Account> accountList) {
        System.out.println("\nYour card has been created");
        Account generatedAccount = new Account(accountList);
        generatedAccount.printDetails();
        accountList.add(generatedAccount);
    }

    public static boolean logIntoAccount(List<Account> accountList, Scanner scanner) {
        int[] cardNumber = enterAccountNumber(scanner);
        int[] accNumber = Account.extractAccountNumFromCardNum(cardNumber);
        int[] accPIN = enterPinNumber(scanner);

        for (Account acc : accountList) {
            if (acc.logInSuccess(accNumber, accPIN)) {
                return true;
            }
        }
        return false;
    }

    public static int[] enterAccountNumber(Scanner scanner) {
        System.out.println("\nEnter your card number:");
        System.out.print(">");
        return parseStringAsIntArray(scanner.nextLine());
    }

    public static int[] enterPinNumber(Scanner scanner) {
        System.out.println("Enter your PIN:");
        System.out.print(">");
        return parseStringAsIntArray(scanner.nextLine());
    }

    public static int[] parseStringAsIntArray(String input) {
        return input
                .chars()
                .mapToObj(item -> (char) item)
                .mapToInt(item -> Integer.parseInt(String.valueOf(item)))
                .toArray();
    }
}