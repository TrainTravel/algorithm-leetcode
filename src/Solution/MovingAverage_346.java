package Solution;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example:
 * MovingAverage_346 m = new MovingAverage_346(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 *
 * @author BorisMirage
 * Time: 2018/10/07 17:20
 * Created with IntelliJ IDEA
 */

public class MovingAverage_346 {
    int size;
    private LinkedList<Integer> q;
    private int sum = 0;

    /**
     * @param size window size
     */
    public MovingAverage_346(int size) {
        this.size = size;
        q = new LinkedList<>();
    }

    /**
     * @param val value add to queue
     * @return average value in queue
     */
    public double next(int val) {
        double res;
        q.addLast(val);
        sum += val;
        if (q.size() > size) {
            sum -= q.pollFirst();
        }
        res = (double) sum / q.size();

        return res;
    }
}
