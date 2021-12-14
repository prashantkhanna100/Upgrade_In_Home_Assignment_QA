package General.General;

import java.util.Random;

/**
 * This class will have some helper methods to avoid some duplicate code.
 */
public class Helper {

    /**
     * Method to generate Random Number
     *
     * @param maxLimit
     * @return
     */
    public static int generateRandomNumber(int maxLimit) {
        Random r = new Random();
        return r.nextInt(maxLimit);
    }
}
