package banking;

import java.util.Arrays;
import java.util.List;

public class Account {

    private final int INN = 400000;
    private final AccountNumber accountNumber;
    private final PIN pin;
    private final int checkDigit;

    private double balance;

    public Account(List<Account> accountList) {
        this.accountNumber = new AccountNumber(accountList);
        this.pin = new PIN();
        this.balance = 0;
        this.checkDigit = LuhnCalculator.getCheckSum(this.INN, this.accountNumber.getDigits());
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
        return Arrays.equals(accountNumber.getDigits(), accountNumberTry)
                && Arrays.equals(this.pin.getDigits(), pinTry);
    }

    public static int[] extractAccountNumFromCardNum(int[] cardNumber) {
        return Arrays.copyOfRange(cardNumber, 6, 15);
    }

    public static void createNewAccount(List<Account> accountList) {
        System.out.println("\nYour card has been created");
        Account generatedAccount = new Account(accountList);
        generatedAccount.printDetails();
        accountList.add(generatedAccount);
    }
}
