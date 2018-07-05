package Mirage.LeetCodeSolution;

/**
 * @author BorisMirage
 * Time: 2018/06/26 20:53
 * Created with IntelliJ IDEA
 */

public class MyPow {
    /**
     * Implement pow(x, n), which calculates x raised to the power n (x^n).
     *
     * x^2n = x^n^2 = x^n * x^n
     *
     * @param x input base double
     * @param n power
     * @return Returns a double containing the results of the power operation.
     */

    public double myPow(double x, int n) {

        /* Special Case */
        if (n == 1) {
            return x;
        }

        long pow = n;
        if (pow < 0) {
            x = 1 / x;
            pow = -pow;
        }
        double res = 1;
        double currentProduct = x;


        for (long i = pow; i > 0; i /= 2) {

            /* Current pow is odd */
            if (i % 2 == 1) {
                res = res * currentProduct;
            }

            /* Current pow is even */
            currentProduct = currentProduct * currentProduct;
        }
        return res;
    }
}
