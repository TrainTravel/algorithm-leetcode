package Solution.Others;

/**
 * Given two non-negative integers num1 and num2 represented as strings.
 * Return the product of num1 and num2, also represented as a string.
 * Note:
 * 1. The length of both num1 and num2 is < 110.
 * 2. Both num1 and num2 contain only digits `0-9`.
 * 3. Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * 4. Do not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author BorisMirage
 * Time: 2018/06/24 14:16
 * Created with IntelliJ IDEA
 */

public class MultiplyString_43 {
    /**
     * Divide multiply into steps, it can be regarded as one digit multi one digit in each time, finally sum all result.
     * Hence, simply apply this process.
     *
     * @param num1 first input number in string format
     * @param num2 second input number in string format
     * @return multiply result in string format
     */
    public String multiply(String num1, String num2) {

        /* Corner case */
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }

        /* Store each result's position.
         * All elements will be combined as a string for string output */
        int[] index = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int currentMultiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int sum = currentMultiply + index[i + j + 1];       // add nums through previous calculation

                /* Put basic and tens into correct position */
                index[i + j] += sum / 10;
                index[i + j + 1] = sum % 10;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < index.length; i++) {
            if (!(i == 0 && index[i] == 0)) {       // avoid leading 0
                res.append(index[i]);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        MultiplyString_43 multiplyTest = new MultiplyString_43();
        String a1 = "123";
        String a2 = "456";
        System.out.println(multiplyTest.multiply(a1, a2));
    }
}
