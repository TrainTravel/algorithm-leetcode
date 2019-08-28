package Playground;

/**
 * You want to do currency exchange between USD and CNY(RMB). You have an array for which the i-th element is the USD to CNY(RMB) exchange rate on day i.
 * Example: [6.4, 6.6, 6.3, 6.5, 6.1, 6.7]
 * And 6.4 means 1 USD can exchange 6.4 CNY(RMB)
 * Now you have USD$1000 in hand, and you are only permitted to buy once and sell once within the given days.
 * Please design an algorithm and implement it with the coding language of your choice to find the maximum profit in USD.
 * Write test cases to demo your implementation.
 * Input: an array of USD to CNY(RMB) exchange rates
 * Output: maximum profit in USD
 * Note that you cannot sell CNY(RMB) before you buy them first.
 *
 * @author BorisMirage
 * Time: 2019/08/22 12:10
 * Created with IntelliJ IDEA
 */

public class BuyAndSell {

    public static double exchange(double[] currency) {
        //corner case
        if (currency.length <= 1) return 0;
        double res = 0;
        double high = currency[0];
        double low = currency[0];
        for (int i = 0; i < currency.length; i++) {
            if (currency[i] > high) {
                res = Math.max(res, 1000 * high / low);
                high = currency[i];
                low = currency[i];
            }
            if (currency[i] < low) {
                low = currency[i];
                res = Math.max(res, 1000 * high / low);
            }
        }
        return res - 1000;
    }

    public double buyAndSell(double[] nums) {
        double max = 0;
        double sum = 0;

        if (nums.length < 2) {
            return 0;
        }

        int buy = 0, sell = 0, start = 0;

        for (int i = 1; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - 1];
            if (sum > 0) {
                sum = 0;    // sum should be negative to make profit
                start = i;
            }

            if (sum < max) {    // new max profit
                max = sum;
                sell = i;
                buy = start;
            }
        }

        if (max == 0) {
            return 0;
        }

        double output = 1000 * nums[buy] / nums[sell];

        return output - 1000;
    }

    public static void main(String[] args) {
        System.out.println(exchange(new double[]{6.4, 6.1, 6.3, 6.5, 6.6, 6.7}));
        System.out.println(exchange(new double[]{6.1, 6.2, 6.3, 6.4, 6.5, 6.6}));
        System.out.println(exchange(new double[]{}));
        System.out.println(exchange(new double[]{6.1}));
        System.out.println(exchange(new double[]{6.4, 6.1, 6.9, 6.5, 6.3, 6.7}));

        System.out.println("=======");

        System.out.println(new BuyAndSell().buyAndSell(new double[]{6.4, 6.1, 6.3, 6.5, 6.6, 6.7}));
        System.out.println(new BuyAndSell().buyAndSell(new double[]{6.1, 6.2, 6.3, 6.4, 6.5, 6.6}));
        System.out.println(new BuyAndSell().buyAndSell(new double[]{}));
        System.out.println(new BuyAndSell().buyAndSell(new double[]{6.1}));
        System.out.println(new BuyAndSell().buyAndSell(new double[]{6.4, 6.1, 6.9, 6.5, 6.3, 6.7}));
    }
}
