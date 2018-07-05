package Mirage.LeetCodeSolution;

import java.util.LinkedList;


/**
 * @author BorisMirage
 * Date: 2018/03/26
 * Time: 15:28
 * Created with IntelliJ IDEA
 */

public class MyAtoi {

    /**
     * Convert string to integer
     *
     * @param str input string
     * @return integer that is converted
     */

    public int myAtoi(String str) {
        LinkedList<Integer> parseList = new LinkedList<>();
        long result = 0;
        int power = 0;
        int cache;
        int plus = 0;
        int minus = 0;
        int validStart = 0;

        if (str.length() == 0) {
            return 0;
        }

        /* Check legitimacy */
        for (int i = 0; i < str.length(); i++) {

            /* ASCII code stands for integer: 48-57 (included) */
            if ((int) str.charAt(i) > 47 && (int) str.charAt(i) < 58) {
                parseList.add((int) str.charAt(i) - 48);
                validStart = 1;
            } else if ((int) str.charAt(i) == 43) {

                /* 43: "+" */
                plus += 1;
                validStart = 1;
            } else if ((int) str.charAt(i) == 45) {
                /* 45: "-" */
                minus += 1;
                validStart = 1;
            }

            if (plus + minus > 1) {
                return 0;
            }
            if ((int) str.charAt(i) > 58 || (int) str.charAt(i) < 47) {
                if ((int) str.charAt(i) != 43 && (int) str.charAt(i) != 45) {
                    if ((int) str.charAt(i) == 32) {
                        if (validStart == 1) {
                            break;
                        }
                    } else break;

                }
            }
        }

        if (parseList.size() == 0) {
            return 0;
        }

        /* Calculate result */
        while (parseList.size() != 0) {
            cache = parseList.getLast();
            result = (long) (cache * Math.pow(10, power) + result);
            power += 1;
            parseList.removeLast();
        }

        if (minus > 0) {
            result *= -1;
        }

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }
}
