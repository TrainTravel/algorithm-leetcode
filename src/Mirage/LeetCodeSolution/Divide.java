package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 6/16/18 23:24
 * Created with IntelliJ IDEA
 */

public class Divide {
    /**
     * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
     * Return the quotient after dividing dividend by divisor.
     * The integer division should truncate toward zero.
     * <p>
     * Note:
     * Both dividend and divisor will be 32-bit signed integers.
     * The divisor will never be 0.
     * Assuming environment could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
     * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
     *
     * @param dividend int dividend
     * @param divisor  int divisor
     * @return quotient
     */
    public int divide(int dividend, int divisor) {

        long dividendLong = Math.abs((long) dividend);
        long divisorLong = Math.abs((long) divisor);

        /* If input overflow */
        if (divisorLong == 0) {
            return Integer.MAX_VALUE;
        }

        /* Special Case */
        if (dividendLong < divisorLong || dividendLong == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }

        /* Use recursion to find result */
        long result = fastDivide(dividendLong, divisorLong);

        /* Avoid overflow */
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if ((divisor > 0 && dividend < 0) || (dividend > 0 && divisor < 0)) {
            return -(int) result;
        }
        return (int) result;
    }

    private long fastDivide(long dividend, long divisor) {

        /* Recursion exit point */
        if (dividend < divisor) {
            return 0;
        }
        long cache = divisor;
        long multi = 1;
        while ((cache + cache) <= dividend) {
            cache += cache;
            multi += multi;
        }
        return multi + fastDivide(dividend - cache, divisor);
    }

}
