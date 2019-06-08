package Solution.Backtracking;


import java.util.Arrays;
import java.util.HashMap;

/**
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10.
 * Player who first causes the running total to reach/exceed 100 wins.
 * Now rule changes to not able to re-use integers.
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement.
 * The first one reaching or exceeding 100 wins.
 * Given an integer <code>maxChoosableInteger</code> and another integer desiredTotal
 * Determine if the first player to move can force a win.
 * <code>maxChoosableInteger</code> will not be larger than 20 and desiredTotal will not be larger than 300.
 *
 * @author BorisMirage
 * Time: 2019/06/08 13:05
 * Created with IntelliJ IDEA
 */

public class CanIWin_464 {

    private HashMap<Integer, Boolean> m = new HashMap<>();       // hash map store backtrack temp result

    /**
     * DFS with pruning to reduce time.
     *
     * @param maxChoosableInteger max choosable integer
     * @param desiredTotal        total to reach
     * @return if the first player to move can force a win
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        /* Corner case */
        if (desiredTotal <= maxChoosableInteger) {
            return true;
        }
        if (maxChoosableInteger + maxChoosableInteger * (maxChoosableInteger - 1) / 2 < desiredTotal) {
            return false;
        }

        return backtracking(maxChoosableInteger + 1, new boolean[maxChoosableInteger + 1], desiredTotal);
    }

    /**
     * Backtracking with a hash map for pruning.
     *
     * @param max          max choosable integer
     * @param chosen       integers has been choosen
     * @param currentTotal current remaining total
     * @return if the first player to move can force a win
     */
    private boolean backtracking(int max, boolean[] chosen, int currentTotal) {
        if (currentTotal <= 0) {
            return false;
        }

        int current = transfer(chosen);
        if (m.containsKey(current)) {
            return m.get(current);
        }

        for (int i = 1; i < max; i++) {
            if (!chosen[i]) {
                chosen[i] = true;

                if (!backtracking(max, chosen, currentTotal - i)) {
                    m.put(current, true);
                    chosen[i] = false;
                    return true;
                }
                chosen[i] = false;
            }
        }
        m.put(current, false);

        return false;
    }


    private int transfer(boolean[] arr) {
        int num = 0;
        for (boolean x : arr) {
            num <<= 1;
            if (x) {
                num |= 1;
            }
        }
        return num;
    }
}
