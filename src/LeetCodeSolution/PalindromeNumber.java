package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/19/18
 * Time: 17:25
 */

public class PalindromeNumber {
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
