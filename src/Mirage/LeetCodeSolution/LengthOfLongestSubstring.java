package Mirage.LeetCodeSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author BorisMirage
 * Time: 3/23/18 12:27
 * Created with IntelliJ IDEA
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

        if (s.length() < 2) {
            return s.length();
        }

        /* Init variables */
        int result = 0;
        int subStart = 0;

        Map<Character, Integer> stringMap = new HashMap<>();

        /* Traverse string */
        for (int i = 0; i < s.length(); i++) {

            /* If current char is in map, compare current index to previous index, set substring start to later one */
            if (stringMap.containsKey(s.charAt(i))) {
                subStart = Math.max(stringMap.get(s.charAt(i)), subStart);
            }
            result = Math.max(result, i - subStart + 1);

            /* In this way, when repetition is found, the calculation will be next char. */
            stringMap.put(s.charAt(i), i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring test = new LengthOfLongestSubstring();
        System.out.println(test.lengthOfLongestSubstring("tmmzuxt"));
        System.out.println(test.lengthOfLongestSubstring("a"));
    }
}


