package banking;

public class PIN implements NumberAsIntArray {
    private int[] digits;

    public PIN() {
        digits = new int[4];
        generatePIN();
    }

    private void generatePIN() {
        for (int i = 0; i < 4; i++) {
            digits[i] = (int) (Math.random() * 10);
        }
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
