package banking;

public class AuthManager {
    public static Account logIntoAccount() {
        int[] cardNumber = enterAccountNumber();
        int[] accNumber = Account.extractAccountNumFromCardNum(cardNumber);
        int[] accPIN = enterPinNumber();

        for (Account acc : Account.accountSet) {
            if (acc.logInSuccess(accNumber, accPIN)) {
                return acc;
            }
        }
        return null;
    }

    public static int[] enterAccountNumber() {
        System.out.println("\nEnter your card number:");
        System.out.print(">");
        return parseStringAsIntArray(Main.scanner.nextLine());
    }

    public static int[] enterPinNumber() {
        System.out.println("Enter your PIN:");
        System.out.print(">");
        return parseStringAsIntArray(Main.scanner.nextLine());
    }

    public static int[] parseStringAsIntArray(String input) {
        return input
                .chars()
                .mapToObj(item -> (char) item)
                .mapToInt(item -> Integer.parseInt(String.valueOf(item)))
                .toArray();
    }
}
