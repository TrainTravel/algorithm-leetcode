package Solution.TwoPointers;

/**
 * From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).
 * Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target.
 * If the task is impossible, return -1.
 *
 * @author BorisMirage
 * Time: 2019/07/17 15:48
 * Created with IntelliJ IDEA
 */

public class ShortestWay_1055 {
    /**
     * Greedy & two pointers.
     *
     * @param source source string
     * @param target target string
     * @returnn minimum number of subsequences of source such that their concatenation equals target
     */
    public int shortestWay(String source, String target) {

        int t = 0, min = 0;

        while (t < target.length()) {

            int start = t;      // mark start position, in case there contains char in target that do not in source

            for (int i = 0; i < source.length(); i++) {

                /*
                 * Find maximum chars in target that can be made up by subsequence of source.
                 * Each time, if a char in source is matched to char in target, move pointer in target forward.
                 * Finally, if target pointer moves to the end of target, return counter. */
                if (t < target.length() && source.charAt(i) == target.charAt(t)) {
                    t++;
                }
            }

            if (start == t) {
                return -1;
            }

            min++;      // find one subsequence
        }

        return min;
    }
}
