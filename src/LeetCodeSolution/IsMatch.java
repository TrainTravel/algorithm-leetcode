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
     *
     * @param s input String
     * @param p input Pattern
     * @return true if found match, false if not
     */
    public boolean isMatch(String s, String p) {

        /* Special case */
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        int j = 0;
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        /* Traverse string and pattern */
        for (int i = 0; i < s.length(); i++) {
            int a = i;
            boolean isCurrentEqual;
            if (sChar[i] == '*') {
                while (sChar[a] == '*') {
                    a--;
                }
                isCurrentEqual = isEqual(sChar[a], pChar[j]);
            } else {
                isCurrentEqual = isEqual(sChar[i], pChar[j]);
            }
            if (isCurrentEqual) {
                j++;
            } else {
                j = 0;
            }
            // todo: Condition that "*" is the last char of Pattern
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
        if (stringChar == patternChar) {
            return true;
        } else if (patternChar == '*') {
            return true;
        }
        return false;
    }
}
