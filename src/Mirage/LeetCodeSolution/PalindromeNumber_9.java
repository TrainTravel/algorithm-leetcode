package Mirage.LeetCodeSolution;

/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * @author BorisMirage
 * Time: 2018/05/19 17:25
 * Created with IntelliJ IDEA
 */

public class PalindromeNumber_9 {
    /**
     * Search_33 starts from the first and last element, each time move forward/backward respectively.
     * If there is a mismatch during the process, then it is not palindrome.
     *
     * @param x input int
     * @return true if number is palindrome
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

    public static void main(String[] args) {

        /* Palindrome Number Test*/
        PalindromeNumber_9 palindromeNumberTest = new PalindromeNumber_9();
        System.out.println(palindromeNumberTest.isPalindrome(0000));
    }
}
