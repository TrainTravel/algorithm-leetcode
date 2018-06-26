import java.util.HashSet;
import java.util.Set;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int longestLen = 1;
        int startLoc = 0;
        int endLoc = 0;
        Set<Character> tmp = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!tmp.contains(cur)) {
                tmp.add(cur);
                endLoc++;
                if (i == s.length() - 1) {

                }
            } else {
                if (endLoc - startLoc > longestLen) {
                    longestLen = endLoc - startLoc;
                }
                startLoc = i;
                endLoc = i;
                tmp = new HashSet<Character>();
            }
        }
        return longestLen;
    }
}