package Solution.Others;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * @author BorisMirage
 * Time: 2018/06/10 15:34
 * Created with IntelliJ IDEA
 */

public class LongestCommonPrefix_14 {
    /**
     * @param strs input string array
     * @return string that represent common prefix
     */
    public String longestCommonPrefix(String[] strs) {

        /* Empty string array */
        if (strs.length == 0) {
            return "";
        }

        /* Traversing all chars of first string in string array */
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {

                /* If first string has common part that is longer than jth,
                   or the ith char in jth string is not common char */
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i))
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}
