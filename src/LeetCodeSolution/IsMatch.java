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
        if (p.equals(".*")) {
            return true;
        }
        if (p.length() == 1) {
            if (s.length() > 1) {
                return false;
            }
        }

        int i = 0;
        int j = 0;

        while (j < p.length()) {

            if (i == s.length() - 1 && j == p.length() - 1) {
                if (isEqual(s.charAt(i), p.charAt(j))) {
                    return true;
                } else return p.charAt(j) == '*' && isEqual(s.charAt(i), p.charAt(j - 1));
            }

            /* Normal situation - two chars are the same */
            if (isEqual(s.charAt(i), p.charAt(j))) {
                if (i != s.length() - 1) {
                    i++;
                }
                j++;

                if (i == s.length() - 1 && j != p.length()) {

                    if (j == p.length() - 2 && p.charAt(j + 1) != '*' && p.charAt(j) != '*') {
                        return false;
                    }
                    if (p.charAt(j + 1) == '*' && j < p.length() - 2) {
                        return false;
                    }
                }
            } else if (p.charAt(j) == '*') {
                if (isEqual(s.charAt(i), p.charAt(j - 1)) && i != s.length() - 1) {
                    i++;
                } else {
                    j++;
                }
            } else if (j == p.length() - 2 && p.charAt(j + 1) == '*') {
                if (isEqual(s.charAt(i), p.charAt(j))) {
                    return true;
                } else return p.length() > 2 && isEqual(s.charAt(i), p.charAt(j - 1));
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
