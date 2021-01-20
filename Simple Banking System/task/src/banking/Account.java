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
                accountNumber +
                pin +
                checkDigit;
    }

}
