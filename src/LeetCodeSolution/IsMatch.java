package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/7/18
 * Time: 19:41
 */

public class IsMatch {

    /**
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
     * '.' Matches ANY single character.
     * '*' Matches zero or more of the PRECEDING element. (Which means "*" will not be first element of string)
     * The matching should cover the entire input string (not partial).
     *
     * @param s input String
     * @param p input Pattern
     * @return true if found match, false if not
     */
    public boolean isMatch(String s, String p) {

        /* Special case */
        if (s.length() == 0 || p.length() == 0) {
            if (s.length() + p.length() != 0) {
                return false;
            }
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < p.length()) {

            /* Normal chars and '.' */
            if (isEqual(s.charAt(i), p.charAt(j))) {
                if (i == s.length() - 1 && j == p.length() - 1) {
                    return true;
                } else {
                    i++;
                    j++;
                }
                if (i == s.length() && j == p.length() - 2 && p.charAt(j + 1) == '*') {
                    return true;
                }
            } else if (p.charAt(j) == '*') {


                if (isEqual(s.charAt(i), p.charAt(j - 1))) {


                    if (i == s.length() - 1 && j == p.length() - 1) {
                        return true;
                    } else if (i == s.length() - 1 && j != p.length() - 1) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    j++;
                }
            } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                j += 2;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Check if input char is equal or not.
     * If patternChar is '.', then always return true.
     * Based on the code in isMatch, '*' will not be passed in isEqual as patternChar.
     *
     * @param stringChar  char from input string
     * @param patternChar char from input pattern
     * @return whether they are matched.
     */
    public boolean isEqual(char stringChar, char patternChar) {
        if (patternChar == '.') {
            return true;
        } else {
            return stringChar == patternChar;
        }
    }
}
