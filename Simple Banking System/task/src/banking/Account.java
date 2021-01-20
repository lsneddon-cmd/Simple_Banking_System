package banking;

import java.util.List;

public class Account {

    private final int INN;
    private final AccountNumber accountNumber;
    private PIN pin;
    private final int checkDigit;

    private double balance;

    public Account(List<Account> accountList) {
        this.INN = 400000;
        this.accountNumber = new AccountNumber(accountList);
        this.pin = new PIN();
        this.checkDigit = 1;
        this.balance = 0;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return  "" +
                INN +
                accountNumber.toString() +
                checkDigit;
    }

    public void printDetails() {
        System.out.println("Your card number:");
        System.out.println(this.toString());
        System.out.println("Your card PIN:");
        System.out.println(this.pin.toString());
        System.out.println();
    }

    public boolean logInSuccess(int[] accountNumberTry, int[] pinTry) {
        return accountNumber.compareNumbers(accountNumberTry) && this.pin.compareNumbers(pinTry);
    }

    public static int[] extractAccountNumFromCardNum(int[] cardNumber) {
        int[] accountNumber = new int[9];
        for (int i = 6; i < 15; i++) {
            accountNumber[i - 6] = cardNumber[i];
        }
        return accountNumber;
    }

    public static void createNewAccount(List<Account> accountList) {
        System.out.println("\nYour card has been created");
        Account generatedAccount = new Account(accountList);
        generatedAccount.printDetails();
        accountList.add(generatedAccount);
    }
}
