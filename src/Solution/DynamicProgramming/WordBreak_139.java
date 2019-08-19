package Solution.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words
 * Determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * @author BorisMirage
 * Time: 2019/06/07 14:15
 * Created with IntelliJ IDEA
 */

public class WordBreak_139 {
    /**
     * Dynamic programming with 1D boolean array.
     * Iterate the given string.
     * Under each substring in iteration, find a breaking point to split both substring exist in dictionary.
     * State transition:
     * dp(i) = true iff dp(j) == true && dic.contains(s.substring(j, i)), where j <= 0 < i.
     * In substring function, j should be from
     *
     * @param s        given string
     * @param wordDict given dictionary
     * @return if s can be segmented into a space-separated sequence of one or more dictionary words
     */
    public boolean wordBreak(String s, List<String> wordDict) {

        /* Corner case */
        if (s.length() == 0 || wordDict.size() == 0) {
            return false;
        }
        HashSet<String> dict = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;       // avoid first char is found in dictionary but marked as false

        for (int i = 1; i < dp.length; i++) {       // iter string
            for (int j = i - 1; j >= 0; j--) {
                /*
                 * Split string into s(0, j) and s(j, i).
                 * There are two conditions:
                 * 1. (0, j) can be previously found in set
                 * 2. s(j, i) can be found in set
                 * Then s(0, i) can be divided. */
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {
        String[] wordDict = {"call", "of", "duty"};
        List<String> l = new ArrayList<>(Arrays.asList(wordDict));
        WordBreak_139 test = new WordBreak_139();
        System.out.println(test.wordBreak("callofduty", l));

        wordDict = new String[]{"car", "ca", "rs"};
        l = Arrays.asList(wordDict);
        System.out.println(test.wordBreak("cars", l));

    }
}
