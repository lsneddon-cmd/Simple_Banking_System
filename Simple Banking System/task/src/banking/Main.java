package banking;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        MainMenu choice;

        while(true) {
            try {
                MainMenu.printMenu();
                choice = MainMenu.values()[scanner.nextInt()];
                switch (choice) {
                    case NEW:
                        createNewAccount(accounts);
                        break;
                    case LOGIN:
                        System.out.println("login to account");
                        return;
                    case EXIT:
                        System.out.println("goodbye");
                        return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inappropriate input");
            }
        }
    }

    public static void createNewAccount(List<Account> accountsList) {
        System.out.println("\nYour card has been created");
        Account generatedAccount = new Account(accountsList);
        generatedAccount.printDetails();
        accountsList.add(generatedAccount);
    }


}