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
        for (int i = 0; i < s.length(); i++) {

            if (i == sChar.length && j == pChar.length && pChar[j] != '*') {
                return isEqual(sChar[i], pChar[j]);
            } else {

                if (pChar[j]=='*'){
                    
                }
            }

        }
        return false;

//
//        /* Traverse string and pattern */
//        for (int i = 0; i < s.length(); i++) {
//            if (pChar[j] == '*' && j != 0) {
//
//                /* If current pattern char is '*' then pattern move forward one char */
//                if (!isEqual(sChar[i], pChar[j - 1])) {
//                    if (j == p.length() - 1) {
//                        return true;
//                    } else if (isEqual(sChar[i], pChar[j + 1])) {
//                        j++;
//                    } else {
//                        j = 0;
//                    }
//                }
//                if (j == p.length() - 1 && isEqual(sChar[i], pChar[j])) {
//                    return true;
//                }
//            } else {
//                /* Normal condition */
//                if (isEqual(sChar[i], pChar[j])){
//                    if (j == p.length() - 1){
//                        return true;
//                    }else {
//                        j++;
//                    }
//                }else {
//                    j=0;
//                }
//            }
//        }
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
