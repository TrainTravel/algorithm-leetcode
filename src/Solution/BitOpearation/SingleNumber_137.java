package Solution.BitOpearation;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 *
 * @author BorisMirage
 * Time: 2019/02/12 17:34
 * Created with IntelliJ IDEA
 */

public class SingleNumber_137 {
    /**
     * Bitwise operation.
     *
     * @param nums int array
     * @return number appears only once
     */
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;        // ~ bitwise compliment, & bitwise and
            b = (b ^ num) & ~a;
        }
        return a;
    }
}
