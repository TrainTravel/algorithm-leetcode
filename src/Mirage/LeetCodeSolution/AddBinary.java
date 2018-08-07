package Mirage.LeetCodeSolution;

/**
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * @author BorisMirage
 * Time: 2018/08/07 13:53
 * Created with IntelliJ IDEA
 */

public class AddBinary {
    /**
     * Traverse all char in string.
     * Use XOR as addition.
     * Be aware of carry.
     *
     * @param a first binary string
     * @param b second binary string
     * @return sum of a and b
     */
    public String addBinary(String a, String b) {

        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder res = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int sum;

        while (i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;

            /* Use XOR as addition */
            sum = aByte ^ bByte ^ carry;

            carry = ((aByte + bByte + carry) > 1) ? 1 : 0;
            res.append(sum);
        }
        return res.reverse().toString();
    }
}
