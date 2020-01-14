package Solution.Array;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 * @author BorisMirage
 * Time: 2020/01/13 19:31
 * Created with IntelliJ IDEA
 */

public class SumZero_1304 {
    /**
     * Math solution:
     * out[i] = i * 2 - n + 1
     * The sequence sum should be 0, which is (a[0] + a[n-1]) * n / 2 = 0. This means a[0] + a[n-1] = 0.
     * Note that a[n-1] - a[0] = (n-1) * delta, which is -2 * a[0].
     * Therefore, simply set delta = 2, a[0] = 1 - n, and this is a sum calculating problem.
     *
     * @param n n unique integers
     * @return any array containing n unique integers such that they add up to 0
     */
    public int[] sumZero(int n) {
        int[] out = new int[n];

        /* Corner case */
        if (n <= 1) {
            return out;
        }

        for (int i = 0; i < out.length; i++) {
            out[i] = i * 2 - n + 1;
        }
        return out;
    }
}
