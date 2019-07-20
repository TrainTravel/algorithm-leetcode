package Solution.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * @author BorisMirage
 * Time: 2019/07/19 17:01
 * Created with IntelliJ IDEA
 */

public class FirstUniqChar_387 {
    /**
     * Use a char array as map.
     *
     * @param s given string
     * @return first non-repeating character's index
     */
    public int firstUniqChar(String s) {

        int[] map = new int[26];

        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
