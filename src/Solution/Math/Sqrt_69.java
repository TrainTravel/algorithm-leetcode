package Solution.Math;

/**
 * Implement int sqrt(int x) and return in int.
 *
 * @author BorisMirage
 * Time: 2019/01/21 23:36
 * Created with IntelliJ IDEA
 */

public class Sqrt_69 {
    /**
     * Bit manipulation.
     *
     * @param x given int
     * @return square root of x
     */
    public int sqrt(int x) {

        /* Corner case */
        if (x == 0) {
            return 0;
        }

        int h = 0;

        /* Find highest bit */
        while ((long) (1 << h) * (long) (1 << h) <= x) {
            h++;
        }
        h--;

        int b = h - 1;
        int res = (1 << h);

        while (b >= 0) {
            if ((long) (res | (1 << b)) * (long) (res | (1 << b)) <= x) {
                res |= (1 << b);
            }
            b--;
        }
        return res;
    }
}
