package banking;

import java.util.List;

public class Account {

    private final int INN;
    private final AccountNumber accountNumber;
    private PIN pin;
    private final int checkDigit;

    public Account(List<Account> accountList) {
        this.INN = 400000;
        this.accountNumber = new AccountNumber(accountList);
        this.pin = new PIN();
        this.checkDigit = 1;
    }

    public AccountNumber getAccountNumber() {
        return accountNumber;
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
}
