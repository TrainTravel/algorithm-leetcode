package Solution.Others;

/**
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * @author BorisMirage
 * Time: 2018/06/22 15:18
 * Created with IntelliJ IDEA
 */

public class CountAndSay_38 {
    /**
     * @param n nth term
     * @return nth term of the count-and-say sequence
     */
    public String countAndSay(int n) {

        /* Corner case */
        if (n < 2) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String res = "11";

        /* Generate next sequence */
        for (int i = 2; i < n; i++) {

            int count = 1;
            StringBuilder round = new StringBuilder();

            /* Traverse previous sequence to generate new sequence */
            for (int j = 1; j < res.length(); j++) {
                if (res.charAt(j - 1) == res.charAt(j)) {
                    count++;
                } else {
                    round.append(count).append(res.charAt(j - 1));
                    count = 1;
                }
            }
            round.append(count).append(res.charAt(res.length() - 1));
            res = round.toString();
        }
        return res;
    }

    public static void main(String[] args) {

        /* Count and Say */
        CountAndSay_38 countAndSayTest = new CountAndSay_38();
        System.out.println(countAndSayTest.countAndSay(6));
    }
}
