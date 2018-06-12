package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/19/18
 * Time: 17:25
 */

public class PalindromeNumber {
    /**
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     *
     * Search starts from the first and last element, each time move forward/backward respectively.
     * If there is a mismatch during the process, then it is not palindrome.
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        char[] charInt = Integer.toString(x).toCharArray();
        for (int i = 0; i < charInt.length / 2; i++) {
            if (charInt[i] != charInt[charInt.length - i - 1]) {
                return false;
            }
        }
        return true;
    }
}
