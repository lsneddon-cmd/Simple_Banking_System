package banking;

import java.util.Random;

public class AccountNumber {
    private final int[] digits;
    private final int accountNumberSize = 9;

    public AccountNumber() {
        int[] temp = generateAccountNumber();
        while (!checkUniqueAccountNumber(temp)) {
            temp = generateAccountNumber();
        }
        this.digits = temp;
    }

    private int[] generateAccountNumber() {
        return new Random()
                .ints(accountNumberSize,0,9)
                .toArray();
    }

    public int[] getDigits() {
        return digits;
    }

    private static boolean checkUniqueAccountNumber(int[] number) {
        return Account.accountSet
                .stream()
                .noneMatch(account -> account.getAccountNumber().equals(number));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int digit : this.digits) {
            sb.append(digit);
        }
        return sb.toString();
    }
}
