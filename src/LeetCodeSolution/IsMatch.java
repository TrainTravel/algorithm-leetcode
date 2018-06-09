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
        if (s.length() == 0) {
            if (p.length() == 0) {
                return true;
            } else {
                return false;
            }
        }

        /* Convert to array */
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();

        /* Pattern Index */
        int j = 0;

        /* Traverse string and pattern, if pattern and string ending at same time, then return true */
        int i = 0;
        while (i < s.length()) {

            /* Last char */
            if (i == s.length() - 1) {

                /* If both char is normal */
                if (j != p.length() - 1 && pChar[j] != '*') {
                    return false;
                } else if (pChar[j] != '*') {
                    return isEqual(sChar[i], pChar[j - 1]);
                } else {
                    return isEqual(sChar[i], pChar[j]);
                }
            } else {

                /* If pattern char is '*' */
                if (pChar[j] == '*') {

                    /* Compare char before and next to current pattern char (0 time and N times) */
                    if (!isEqual(sChar[i], pChar[j - 1]) && !isEqual(sChar[i], pChar[j + 1])) {

                        /* If previous and next pattern char is not equal, then return false */
                        return false;
                    }
                } else {

                    /* Normal case */
                    if (isEqual(sChar[i], pChar[j])) {
                        j++;
                    } else {
                        return false;
                    }
                }
            }
            i++;
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
