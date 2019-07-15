package Solution.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

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
        Map<Character, Integer> m = new HashMap<>();
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            if (m.containsKey(s.charAt(i))) {       // current char in map (duplicated)
                start = Math.max(m.get(s.charAt(i)) + 1, start);        // compare current index to previous index
            }
            max = Math.max(max, i - start + 1);

            m.put(s.charAt(i), i);      // continue at next char, if char is duplicated, reset start index
        }

        return max;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring_3 test = new LengthOfLongestSubstring_3();
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(test.lengthOfLongestSubstring("a"));
        System.out.println(test.lengthOfLongestSubstring("dvdf"));      // answer: 3

    }
}


