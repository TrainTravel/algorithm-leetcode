package Solution.SlidingWindow;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * @author BorisMirage
 * Time: 2018/03/23 12:27
 * Created with IntelliJ IDEA
 */

public class LengthOfLongestSubstring_3 {
    /**
     * Construct a new map to store previous chars.
     * key - char
     * value - next position
     * If current char does not exist in map, then store this char and its next position.
     * If current char exists in map, reset the position to current char's next. (No duplication)
     * Compare current non-repeating substring length to max length and find longer one.
     *
     * @param s input string
     * @return max sub-string length
     */
    public int lengthOfLongestSubstring(String s) {

        /* Corner case */
        if (s.length() < 2) {
            return s.length();
        }

        int max = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            if (m.containsKey(s.charAt(i))) {
                start = Math.max(start, m.get(s.charAt(i)));        // update start to largest to avoid duplicate
            }
            m.put(s.charAt(i), i + 1);
            max = Math.max(i - start + 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 test = new LengthOfLongestSubstring_3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));       // 3
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));       // 5
        System.out.println(test.lengthOfLongestSubstring("a"));
        System.out.println(test.lengthOfLongestSubstring("dvdf"));      // answer: 3
    }
}


