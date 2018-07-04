package Mirage.LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 7/4/18
 * Time: 15:48
 */

public class LengthOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' '.
     * Return the length of last word in the string.
     * If the last word does not exist, return 0.
     * <p>
     * Note: A word is defined as a character sequence consists of non-space characters only.
     *
     * @param s input string
     * @return length of last word
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int length = s.length() - 1;
        while (length > -1 && s.charAt(length) == ' ') {
            length--;
        }
        System.out.println(length);
        while (length > -1 && s.charAt(length) != ' ') {
            length--;
        }
        System.out.println(length);
        return s.length() - length;
    }
}
