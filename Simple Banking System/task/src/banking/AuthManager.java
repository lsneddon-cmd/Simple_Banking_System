package banking;

import java.util.Scanner;
import java.util.Set;

public class AuthManager {
    public static Account logIntoAccount(Set<Account> accountList, Scanner scanner) {
        int[] cardNumber = enterAccountNumber(scanner);
        int[] accNumber = Account.extractAccountNumFromCardNum(cardNumber);
        int[] accPIN = enterPinNumber(scanner);

        for (Account acc : accountList) {
            if (acc.logInSuccess(accNumber, accPIN)) {
                return acc;
            }
        }
        return null;
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
