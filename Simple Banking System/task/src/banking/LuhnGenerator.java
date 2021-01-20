package banking;

public class LuhnGenerator {
    private int[] digits;
    private int checkSum;

    public LuhnGenerator(int INN, int[] acc) {
        digits = new int[15];
        digits[0] = 4;
        for (int i = 1; i < 6; i++) {
            digits[i] = 0;
        }
        for (int i = 6; i < 15; i++) {
            digits[i] = acc[i + 6];
        }
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
    }

    public int getCheckSum() {
        this.checkSum = 0;
        return checkSum;
    }
}
