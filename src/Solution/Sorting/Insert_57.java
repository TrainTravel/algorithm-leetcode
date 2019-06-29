package Solution.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * It may be assumed that the intervals were initially sorted according to their start times.
 * Only one interval will be given.
 *
 * @author BorisMirage
 * Time: 2018/07/10 00:02
 * Created with IntelliJ IDEA
 */

public class Insert_57 {
    /**
     * Starts from new interval. New interval is the temporary value.
     * If given internal's right bound is smaller than left bound of new interval, insert given interval into list.
     * If new interval is smaller than given internal, insert new interval into list, replace temp value by given interval.
     * These two situations are both non-overlapping. If found a overlapping, find larger bound of each value and continue.
     * Finally, after the iteration, add final temp value into list.
     *
     * @param intervals   interval list
     * @param newInterval new interval to be inserted
     * @return new array with input interval inserted
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> out = new ArrayList<>();
        int[] temp = newInterval;

        for (int[] interval : intervals) {      // during the iteration, interval[i][0] <= interval[i+1][0]

            if (temp[0] > interval[1]) {
                out.add(interval);
            } else if (temp[1] < interval[0]) {
                out.add(temp);
                temp = interval;
            } else {
                temp[0] = Math.min(temp[0], interval[0]);
                temp[1] = Math.max(temp[1], interval[1]);
            }
        }
        out.add(temp);
        return out.toArray(new int[out.size()][]);
    }

    public static void main(String[] args) {
        Insert_57 test = new Insert_57();
        System.out.println(Arrays.deepToString(test.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8})));
    }
}
