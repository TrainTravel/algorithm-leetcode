package Solution.Others;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
 *
 * @author BorisMirage
 * Time: 2019/11/05 11:58
 * Created with IntelliJ IDEA
 */
public class NumberToWords_273 {
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};      // "" actually will not be used

    /**
     * Consider all corner case.
     * The unit of division is 1000. Then divide by 100 if larger than 100, divide by 10 if larger than 10.
     *
     * @param num given number
     * @return English word represents this number
     */
    public String numberToWords(int num) {

        /* Corner case */
        if (num == 0) {
            return "Zero";
        }

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                words.insert(0, helper(num % 1000) + THOUSANDS[i] + " ");
            }

            num /= 1000;
            i++;
        }

        return words.toString().trim();
    }

    /**
     * Recursively call the function based on remainder value.
     *
     * @param num given number
     * @return converted string
     */
    private String helper(int num) {

        if (num == 0) {
            return "";
        } else if (num < 20) {      // each case is different when num < 20
            return LESS_THAN_20[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}
