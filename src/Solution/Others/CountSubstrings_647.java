package Solution.Others;

public class CountSubstrings_647 {
    public int countSubstrings(String s) {

        /* Corner case */
        if (s == null || s.length() == 0) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += extend(s, i, i);                 // odd length palindromic substring center
            count += extend(s, i, i + 1);       // even length palindromic substring center
        }

        return count;
    }

    private int extend(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {
            count++;
        }

        return count;
    }
}
