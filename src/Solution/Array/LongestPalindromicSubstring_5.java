package Solution.Array;

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
        if (s.length() == 0 || s.length() == 1) {
            return s;
        }

        /* Set max to 0 to return first letter if there is no palindromic substring */
        int maxStart = 0;
        int maxEnd = 0;

        /* Traverse every char in s and find center of Palindromic Substring */
        for (int i = 0; i < s.length() - 1; i++) {

            /* If center has one letter  */
            int oddCenter = findCenter(s, i, i);

            /* If center has two letters */
            int evenCenter = findCenter(s, i, i + 1);

            int currentLength = Math.max(oddCenter, evenCenter);

            /* Set max length's start and end for slicing when loop is over */
            if (currentLength > maxEnd - maxStart) {
                maxStart = i - (currentLength - 1) / 2;
                maxEnd = i + currentLength / 2;
            }

        }
        return s.substring(maxStart, maxEnd + 1);
    }

    private int findCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {

        /* Longest Palindromic Substring Test*/
        LongestPalindromicSubstring_5 longestPalindromicSubstringTest = new LongestPalindromicSubstring_5();
        System.out.println(longestPalindromicSubstringTest.longestPalindrome("s"));
    }
}
