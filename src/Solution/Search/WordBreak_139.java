package Solution.Search;

import java.util.ArrayList;
import java.util.Arrays;
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
     * Under each substring in iteration, find a breaking point to spilt both substring exist in dictionary.
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

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;       // avoid first char is found in dictionary but marked as false

        for (int i = 1; i < dp.length; i++) {       // iter string
            for (int j = i; j > -1; j--) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }


    public static void main(String[] args) {

        String s = "callofduty";
        String[] wordDict = {"call", "of", "duty"};
        List<String> l = new ArrayList<>(Arrays.asList(wordDict));
        WordBreak_139 test = new WordBreak_139();
        System.out.println(test.wordBreak(s, l));

        wordDict = new String[]{"car", "ca", "rs"};
        l = Arrays.asList(wordDict);
        System.out.println(test.wordBreak("cars", l));

    }
}
