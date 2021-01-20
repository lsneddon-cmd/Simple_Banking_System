package banking;

public class PIN {
    private final int[] digits;

    public PIN() {
        digits = new int[4];
        generatePIN();
    }

    public PIN(int a, int b, int c, int d) {
        this.digits = new int[] {a, b, c, d};
    }

    private void generatePIN() {
        for (int digit: digits) {
            digit = (int) (Math.random() * 10);
        }
    }

    public int getDigit(int index) {
        return digits[index];
    }

    public static boolean comparePINs(PIN first, PIN second) {
        for (int i = 0; i < 4; i++) {
            if (first.getDigit(i) != first.getDigit(i)) {
                return false;
            }
        }
        return true;
    }
}
