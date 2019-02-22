package Solution.Structure;

import java.util.LinkedList;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example:
 * MovingAverage m = new MovingAverage(3);
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
    private int size;
    private LinkedList<Integer> q = new LinkedList<>();
    private double sum = 0;

    /**
     * Data structure initialize.
     *
     * @param size windows size that control the queue size
     */
    public MovingAverage_346(int size) {
        this.size = size;
    }

    /**
     * Add int to queue and return ave of all value in queue.
     * If queue size is larger than limit, poll first element of queue.
     *
     * @param val given value
     * @return average of queue
     */
    public double next(int val) {
        sum += val;
        q.add(val);
        if (q.size() > size && !q.isEmpty()) {
            sum -= q.poll();
        }
        return sum / q.size();
    }
}
