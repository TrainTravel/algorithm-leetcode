package Helper;


/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/26/18
 * Time: 19:15
 */

public class LongestCommonSubstring {
    private int[][] lengthTable;
    private String str1;
    private String str2;


    /**
     * Find longest common substring between two strings.
     * This can be used in finding palindromic substring
     *
     * @param strA first input string
     * @param strB second input string
     */
    public LongestCommonSubstring(String strA, String strB) {
        str1 = strA;
        if (strA.equals(strB)) {
            str2 = reverseStr(strA);
        } else {
            str2 = strB;
        }
        int[][] lengthTable = new int[str1.length()][str2.length()];
    }

    public int[][] findLCS() {
        char[] char_str1 = str1.toCharArray();
        char[] char_str2 = str2.toCharArray();


        return lengthTable;
    }


    /**
     * Reverse string.
     * This is a private method for same string.
     *
     * @param toReverse string to be reversed
     * @return reversed string.
     */
    private String reverseStr(String toReverse) {
        char[] reverse = toReverse.toCharArray();
        for (int i = 0; i < reverse.length / 2; i++) {
            char cache = reverse[i];
            reverse[i] = reverse[reverse.length - 1 - i];
            reverse[reverse.length - 1 - i] = cache;
        }

        /* Convert char[] to string. */
        return String.valueOf(reverse);
    }

    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "abcdefg";
        LongestCommonSubstring longestCommonSubstringTest = new LongestCommonSubstring(str1, str2);
        System.out.println(longestCommonSubstringTest.reverseStr(str1));
    }
}
