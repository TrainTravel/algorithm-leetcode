package Olivia;

public class LongestPalindrome5 {
    int maxLength = 0;
    int loc = 0;

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length(); i++) {
            extendPalindrome(s, i, i);//odd number
            extendPalindrome(s, i, i + 1);//even number
        }
        return s.substring(loc, loc + maxLength - 1);
    }

    private void extendPalindrome(String s, int startloc1, int startloc2) {
        int cur = 0;
        while (startloc1 >= 0 && startloc2 < s.length() && s.charAt(startloc1) == s.charAt(startloc2)) {
            startloc1--;
            startloc2++;
        }
        cur = startloc2 - startloc1 - 1;
        if (cur > maxLength) {
            maxLength = cur;
            loc = startloc1 + 1;
        }
    }
}
