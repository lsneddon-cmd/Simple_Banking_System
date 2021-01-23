package banking;

import java.util.Arrays;

public class LuhnGenerator {
    private int[] digits;
    private int controlNumber;
    private int checkSum;

    public LuhnGenerator(int[] acc) {
        digits = new int[15];
        digits[0] = 4;
        for (int i = 1; i < 6; i++) {
            digits[i] = 0;
        }
        for (int i = 6; i < 15; i++) {
            digits[i] = acc[i - 6];
        }
        this.controlNumber = calculateControlNumber(digits);
        this.checkSum = calculateCheckSum(this.controlNumber);
    }

    public static int calculateControlNumber(int[] numbers) {
        int[] calculations = new int[numbers.length];

        for (int i = numbers.length - 1; i >= 0; i-=2) {
            if (numbers[i] * 2 > 9) {
                calculations[i] = numbers[i] * 2 - 9;
            } else {
                calculations[i] = numbers[i] * 2;
            }
        }

        for (int i = numbers.length - 2; i >= 0; i-=2) {
            calculations[i] = numbers[i];
        }

        return Arrays.stream(calculations).sum();
    }

    public static int calculateCheckSum(int control) {
        return control % 10 == 0 ? 0 : 10 - control % 10;
    }

    public int getCheckSum() {
        return checkSum;
    }

}
