package banking;

import java.util.Arrays;

public class LuhnCalculator {

    private static int calculateControlNumber(int[] numbers) {
        // TODO replace raw loops with functional streams
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

    private static int calculateCheckSum(int control) {
        return control % 10 == 0 ? 0 : 10 - control % 10;
    }

    public static int getCheckSum(int INN, int[] accNum) {
        int[] concatNum = new int[accNum.length + 6];

        int[] inn =
                Arrays.stream(Integer.valueOf(INN).toString().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        System.arraycopy(inn, 0, concatNum, 0, 5);
        System.arraycopy(accNum, 0, concatNum, 6, 9);

        return calculateCheckSum(calculateControlNumber(concatNum));
    }

    public static boolean validateCheckSum(int[] cardNumber) {
        int[] numberMinusLast = new int[cardNumber.length - 1];
        System.arraycopy(cardNumber, 0,numberMinusLast, 0, cardNumber.length - 1);
        return cardNumber[15] == calculateCheckSum(calculateControlNumber(numberMinusLast));
    }
}
