package Mirage.LeetCodeSolution;


/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/10/18
 * Time: 15:04
 */

public class IntToRoman {
    /**
     * Convert int to Roman numerals.
     * Subtracting int num from largest Roman numeral (M).
     * I can be placed before V (5) and X (10) to make 4(IV) and 9(IX).
     * X can be placed before L (50) and C (100) to make 40(XL) and 90(XC).
     * C can be placed before D (500) and M (1000) to make 400(CD) and 900(CM).
     *
     * Started from the largest int(1000), subtract the largest that is not larger than current num.
     * Combine represented Roman numerals each subtraction.
     *
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
     * @param num input int number
     * @return string Roman numerals
     */
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        /* Subtracting int num from largest Roman numeral (M) until num goes to 0 */
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(numerals[i]);
            }
        }
        return result.toString();
    }
}
