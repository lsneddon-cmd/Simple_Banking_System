package banking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Account {
    
    public static Set<Account> accountSet = new HashSet<>();

    private final int INN = 400000;
    private final AccountNumber accountNumber;
    private final PIN pin;
    private final int checkDigit;

    private double balance;

    public Account() {
        this.accountNumber = new AccountNumber();
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

    public static void createNewAccount() {
        System.out.println("\nYour card has been created");
        Account generatedAccount = new Account();
        generatedAccount.printDetails();
        accountSet.add(generatedAccount);
    }
}
