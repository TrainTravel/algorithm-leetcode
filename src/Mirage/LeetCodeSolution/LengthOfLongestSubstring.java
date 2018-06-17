package Mirage.LeetCodeSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/23/18
 * Time: 12:27
 */


public class LengthOfLongestSubstring {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     * <p>
     * Construct a new map to store previous chars.
     * key - char
     * value - next position
     * <p>
     * When current char does not exist in map, then store this char and its next position.
     * When current char exists in map, reset the position to current char's next. (No duplication)
     * Compare current non-repeating substring length to max length, switch them if current length is longer.
     *
     * @param s input string
     * @return max sub-string length
     */

    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }

        /* Init variables */
        int result = 0;
        int subStart = 0;

        /* Init new map */
        Map<Character, Integer> thisMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {

            if (thisMap.containsKey(s.charAt(i))) {
                subStart = Math.max(thisMap.get(s.charAt(i)), subStart);
            }
            result = Math.max(result, i - subStart + 1);

            /* In this way, when repetition is found, the calculation will be next char. */
            thisMap.put(s.charAt(i), i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(test.lengthOfLongestSubstring("a"));
    }
}


