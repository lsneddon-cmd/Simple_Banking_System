package banking;

public class PIN implements ReferenceNumber {
    private int[] digits;

    public PIN() {
        digits = new int[4];
        generatePIN();
    }

    public PIN(int a, int b, int c, int d) {
        this.digits = new int[] {a, b, c, d};
    }

    private void generatePIN() {
        for (int i = 0; i < 4; i++) {
            digits[i] = (int) (Math.random() * 10);
        }
    }

    public int getDigit(int index) {
        return digits[index];
    }

    public boolean comparePINs(int[] comparator) {
        for (int i = 0; i < 4; i++) {
            if (this.digits[i] != comparator[i]) {
                return false;
            }
        }
        return true;
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
