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
     * First of all, sort the array by each interval's first element (interval start).
     * After sorting, interval[i][0] <= interval[i+1][0]. Therefore, to check overlapping, compare interval[i][1].
     * If current interval left bound is smaller than previous interval right bound, then there is an overlapping.
     * Set right bound to larger one.
     * If two intervals have no overlapping, add it to result and update previous checking interval to current one.
     * Finally, add one last interval. Since only add intervals when disjoint interval was found.
     *
     * @param intervals input Interval list
     * @return merged result
     */
    public int[][] merge(int[][] intervals) {

        /* Corner case */
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {        // sort based on interval start
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
//        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> list = new LinkedList<>();
        int[] current = intervals[0];       // first interval

        for (int[] tmp : intervals) {
            if (tmp[0] <= current[1]) {     // if tmp[0] <= current[1], then there must be overlap
                current[1] = Math.max(tmp[1], current[1]);      // find larger right bound to merge interval
            } else {                        // otherwise, it is disjoint intervals
                list.add(current);          // add the new interval to the list
                current = tmp;              // update temp
            }
        }
        list.add(current);      // add final interval

        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Merge_56 test = new Merge_56();
        System.out.println(Arrays.deepToString(test.merge(new int[][]{{15, 18}, {2, 6}, {1, 3}, {8, 10}})));
    }
}

