package Solution.Sorting;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * @author BorisMirage
 * Time: 2018/06/30 17:19
 * Created with IntelliJ IDEA
 */

public class Merge_56 {
    /**
     * Sort the array first by each interval's first element.
     * Then add each interval.
     * After sorting, interval[i][0] <= interval[i+1][0]. Therefore, to check overlapping, compare interval[i][1].
     * If current interval left bound is smaller than previous interval right bound, then there is an overlapping.
     * Reset right bound to larger one.
     * If two intervals have no overlapping, add it to result and update previous checking interval to current one.
     *
     * @param intervals input Interval list
     * @return merged result
     */
    public int[][] merge(int[][] intervals) {

        /* Corner case */
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));     // sort based on intervals[i][0]

//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });

        List<int[]> out = new ArrayList<>();
        int[] temp = intervals[0];
        out.add(temp);

        for (int[] interval : intervals) {      // during the iteration, interval[i][0] <= interval[i+1][0]
            if (interval[0] <= temp[1]) {        // overlapping intervals
                temp[1] = Math.max(temp[1], interval[1]);     // find larger right bound to merge interval
            } else {                             // disjoint intervals
                temp = interval;
                out.add(temp);       // add the new interval to the list and update temp
            }
        }

        return out.toArray(new int[out.size()][]);
    }

    public static void main(String[] args) {
        Merge_56 test = new Merge_56();
        System.out.println(Arrays.deepToString(test.merge(new int[][]{{15, 18}, {2, 6}, {1, 3}, {8, 10}})));
    }
}

