package banking;

import java.util.List;

public class AccountNumber implements NumberAsIntArray {
    private final int[] digits;

    public AccountNumber(List<Account> accounts) {
        int[] temp = generateAccountNumber();
        while (!checkUniqueAccountNumber(accounts, temp)) {
            temp = generateAccountNumber();
        }
        this.digits = temp;
    }

    private int[] generateAccountNumber() {
        int[] res = new int[9];
        for (int i = 0; i < 9; i++) {
            res[i] = (int) (Math.random() * 10);
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

    public boolean compareNumbers(int[] comparator) {
        for (int i = 0; i < 4; i++) {
            if (this.digits[i] != comparator[i]) {
                return false;
            }
        }
        return true;
    }

    public String flattenAsString() {
        StringBuilder sb = new StringBuilder();
        for (int digit : this.digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return flattenAsString();
    }
}
