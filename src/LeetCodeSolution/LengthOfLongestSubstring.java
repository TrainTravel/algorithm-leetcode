package LeetCodeSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/23/18
 * Time: 12:27
 */

//            map.put(s.charAt(j), j + 1);
//                    i = Math.max(map.get(s.charAt(j)), i);

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        int max = 0;
        int cache = 0;
        Map<Character, Integer> thisMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charInString = s.charAt(i);
            if (thisMap.containsKey(charInString)) {
                max = Math.max(max, cache);
                cache = 0;
            } else {
                thisMap.put(charInString, i + 1);
                cache += 1;
            }
        }

        return result;
    }
}