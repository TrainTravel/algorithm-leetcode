package Solution.Backtracking;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * Follow means a full match, that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * @author BorisMirage
 * Time: 2019/09/10 21:00
 * Created with IntelliJ IDEA
 */

public class WordPatternMatch_291 {
    /**
     * Backtracking with hash map and hash set as pruning.
     *
     * @param pattern given pattern string
     * @param str     given string
     * @return if str follows the same pattern
     */
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> m = new HashMap<>();
        HashSet<String> s = new HashSet<>();
        return backtracking(str, pattern, m, s, 0, 0);
    }

    /**
     * @param str given string
     * @param p   given pattern string
     * @param m   hash map stores pattern char and corresponding string
     * @param s   hash set stores each char in pattern's corresponding string
     * @param i   start index of string
     * @param j   start index of pattern
     * @return if str follows the same pattern
     */
    private boolean backtracking(String str, String p, HashMap<Character, String> m, HashSet<String> s, int i, int j) {

        /*
         * Exit point.
         * If reaches the end of string or pattern, check if both string and pattern reaches the end.
         * If only string or pattern reaches the end, that means they are not matched.
         * Otherwise, they are matched. */
        if (i == str.length() || j == p.length()) {
            return (i == str.length() && j == p.length());
        }

        char c = p.charAt(j);

        /*
         * Initially, find all possible first pattern corresponding to first char in pattern string.
         * If current char in pattern is not found in map, then directly move to adding process.
         * Otherwise, check if current pattern matches the string. */
        if (m.containsKey(c)) {

            /*
             * Map stores each pattern and its corresponding sub string in string.
             * If current pattern char is found in map, then check if current string starts with current pattern.
             * If string starts with current pattern, continue backtracking.
             * Otherwise, current pattern is not matched and return false. */
            String tmp = m.get(c);
            if (!str.startsWith(tmp, i)) {
                return false;
            }
            return backtracking(str, p, m, s, i + tmp.length(), j + 1);
        }

        /*
         * Construct map.
         * Each time, try to build up the first pattern by each length and continue backtracking. */
        for (int k = i; k < str.length(); k++) {
            String tmp = str.substring(i, k + 1);
            if (!s.contains(tmp)) {
                s.add(tmp);
                m.put(c, tmp);

                /*
                * The string start position in backtracking should be string without current pattern.
                * The pattern start position in backtracking should be next char in pattern. */
                if (backtracking(str, p, m, s, k + 1, j + 1)) {
                    return true;
                }
                s.remove(tmp);
                m.remove(c);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new WordPatternMatch_291().wordPatternMatch("abab", "redblueredblue"));
        System.out.println(new WordPatternMatch_291().wordPatternMatch("aaaa", "asdasdasdasd"));
        System.out.println(new WordPatternMatch_291().wordPatternMatch("aabb", "xyzabcxzyabc"));
    }
}
