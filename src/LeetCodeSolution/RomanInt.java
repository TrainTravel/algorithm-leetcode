package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/10/18
 * Time: 14:30
 */

public class RomanInt {
    /**
     * Convert Roman numerals to int
     * I can be placed before V (5) and X (10) to make 4(IV) and 9(IX).
     * X can be placed before L (50) and C (100) to make 40(XL) and 90(XC).
     * C can be placed before D (500) and M (1000) to make 400(CD) and 900(CM).
     * <p>
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param s input Roman numerals
     * @return converted int
     */
    public int romanToInt(String s) {
        int result = 0;
        char[] sChar = s.toCharArray();
        int i = s.length() - 1;
        while (i >= 0) {
            result += intMap(sChar[i]);
            if (i > 0) {
                if (intMap(sChar[i - 1]) < intMap(sChar[i])) {
                    result -= intMap(sChar[i - 1]);
                    i -= 2;
                } else {
                    i--;
                }
            } else {
                break;
            }
        }
        return result;

    }

    public int intMap(char roman) {
        int romanInt = 0;
        if (roman == 'I') {
            romanInt = 1;
        } else if (roman == 'V') {
            romanInt = 5;
        } else if (roman == 'X') {
            romanInt = 10;
        } else if (roman == 'L') {
            romanInt = 50;
        } else if (roman == 'C') {
            romanInt = 100;
        } else if (roman == 'D') {
            romanInt = 500;
        } else if (roman == 'M') {
            romanInt = 1000;
        }
        return romanInt;
    }
}
