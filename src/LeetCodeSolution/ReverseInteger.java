package LeetCodeSolution;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 3/26/18
 * Time: 12:39
 */

class ReverseInteger {
    public int reverseInteger(int x) {
        ArrayList<Integer> numArray = new ArrayList<>();

        if (x == 0) {
            return 0;
        }

        long result = 0;
        int count = 0;
        while (x != 0) {
            numArray.add(x % 10);
            x = x / 10;
        }
        while (numArray.size() > 0) {
            result = (long) (result + numArray.get(numArray.size() - 1) * Math.pow(10, count));
            count += 1;
            numArray.remove(numArray.size() - 1);
        }

        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        return (int) result;
    }
}