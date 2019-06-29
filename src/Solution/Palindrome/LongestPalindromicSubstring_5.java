package Solution.Palindrome;

/**
 * Find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * If there does not exist a palindromic substring, then return first letter.
 *
 * @author BorisMirage
 * Time: 2018/05/12 16:43
 * Created with IntelliJ IDEA
 */

public class LongestPalindromicSubstring_5 {
    /**
     * There are two conditions of palindromic substring.
     * First is that the center only contains one letter, such as "aba".
     * Second is that the center contains two letters, such as "abba".
     * Hence, Each one or two adjacent letters could be center of palindromic substring.
     *
     * @param s given string
     * @return longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }

        int maxStart = 0;       // return first letter if there is no palindromic substring
        int maxEnd = 0;

        for (int i = 0; i < s.length() - 1; i++) {      // traverse s to find center of Palindromic Substring

            int oddCenter = findLength(s, i, i);        // center has one letter
            int evenCenter = findLength(s, i, i + 1);       // center has two letters

            int currentLength = Math.max(oddCenter, evenCenter);

            /* Set max length's start and end for slicing when loop is over */
            if (currentLength > maxEnd - maxStart) {
                maxStart = i - (currentLength - 1) / 2;
                maxEnd = i + currentLength / 2;
            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }

    /**
     * Find center of palindromic substring.
     *
     * @param s     given string
     * @param left  left bound of palindromic substring
     * @param right right bound of palindromic substring
     * @return length of palindromic substring
     */
    private int findLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Dynamic programming.
     * This solution is slower than brute force approach.
     *
     * @param s given string
     * @return longest palindromic substring in s
     */
    public String dynamicProgramming(String s) {
        int n = s.length();
        int start = 0, length = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) { // keep increasing the possible palindrome string
            for (int j = i; j < n; j++) { // find the max palindrome within this window of (i,j)

                /*
                 * Check if substring between (i,j) is palindrome.
                 * If window is less than or equal to 3, just end chars should match
                 * If window is > 3, substring (i+1, j-1) should be palindrome as well. */
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);


                if (dp[i][j] && (j - i + 1 > length)) {     // update max palindrome string
                    start = i;
                    length = j - i + 1;
                }
            }
        }
        return s.substring(start, start + length);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 test = new LongestPalindromicSubstring_5();
        System.out.println(test.longestPalindrome("s"));
    }
}
