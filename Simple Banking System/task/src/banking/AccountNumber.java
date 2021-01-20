package banking;

import java.util.List;

public class AccountNumber {
    private final int[] number;

    public AccountNumber(List<Account> accounts) {
        int[] temp = generateAccountNumber();
        while (!checkUniqueAccountNumber(accounts, temp)) {
            temp = generateAccountNumber();
        }
        this.number = temp;
    }

    private int[] generateAccountNumber() {
        int[] res = new int[9];
        for (int digit : res) {
            digit = (int) (Math.random() * 10);
        }
        return res;
    }

    private static boolean checkUniqueAccountNumber(List<Account> accounts, int[] number) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(number)) {
                return false;
            }
        }
        return true;
    }

}
