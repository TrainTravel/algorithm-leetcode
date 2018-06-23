package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/22/18
 * Time: 15:18
 */

public class CountAndSay {
    /**
     * Given an integer n, generate the nth term of the count-and-say sequence.
     * Note: Each term of the sequence of integers will be represented as a string.
     *
     * @param n nth term
     * @return nth term of the count-and-say sequence
     */
    public String countAndSay(int n) {

        /* Special Case */
        if (n < 2) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String res = "11";

        /* Generate next sequence */
        for (int i = 2; i < n; i++) {

            int count = 1;
            StringBuilder round = new StringBuilder();
            /* Traverse previous sequence to generate new sequence */
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j - 1) == res.charAt(j)) {
                    count++;
                } else {
                    round.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            round.append(count).append(res.charAt(res.length() - 1));
            res = round.toString();
        }
        return res;
    }
}
