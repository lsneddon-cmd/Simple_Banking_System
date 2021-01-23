package banking;

import java.util.Arrays;
import java.util.Random;

public class PIN {
    private int[] digits;

    public PIN() {
        this.digits = new Random()
                .ints(4, 0, 9)
                .toArray();
    }

    public int[] getDigits() {
        return digits;
    }

    public void setDigits(String newPin, String newPinAgain) {
        // TODO prevent PINs being set with other than 0-9 integers
        if (newPin.length() != 4 || newPinAgain.length() != 4) {
            throw new IllegalArgumentException("PIN must be 4 digits long");
        }
        int[] newPinArr =
                Arrays.stream(newPin.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        int[] newPinArrAgain =
                Arrays.stream(newPinAgain.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        if (Arrays.equals(newPinArr, newPinArrAgain)) {
            this.digits = newPinArr;
        } else {
            throw new IllegalArgumentException("Both PINs must match\nTry again.");
        }
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
