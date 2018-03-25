package LeetCodeSolution;

import java.util.HashMap;
import java.util.Map;
import java.util.UnknownFormatConversionException;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/23/18
 * Time: 12:27
 */


class LengthOfLongestSubstring {
    /**
     * key - char
     * value - next position
     *
     * When char IS NOT found in map, the value that key store is NEXT position.
     * In this way, when char IS found in map,
     * what get() method will obtain is the next position,
     * which will avoid to include duplicated char in sub-string
     *
     * Then, compare to old max sub length.
     *
     * @param s input string
     * @return max sub-string length
     */
    public int lengthOfLongestSubstring(String s) {

        /* Init variables */
        int result = 0;
        int subStart = 0;

        /* Init new map */
        Map<Character, Integer> thisMap = new HashMap<>();

        if (s.length() == 1) {
            return 1;
        }

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            if (thisMap.containsKey(currentChar)) {
                subStart = Math.max(thisMap.get(currentChar), subStart);
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
    }
}


