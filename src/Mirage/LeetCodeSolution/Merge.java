package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BorisMirage
 * Time: 6/30/18 17:19
 * Created with IntelliJ IDEA
 */

public class Merge {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * Using two arrays to store each interval's start and end. Sort each array respectively.
     * Traverse these two arrays and add new Interval into result based on this:
     * Current Interval's end will be smaller than next Interval's start.
     * Hence, if start in start array is smaller than end array, move to next.
     *
     * @param intervals input Interval list
     * @return merged result
     */
    public List<Interval> merge(List<Interval> intervals) {

        /* Special Case */
        if (intervals.size() < 2) {
            return intervals;
        }

        List<Interval> res = new ArrayList<>();
        int[] startArray = new int[intervals.size()];
        int[] endArray = new int[intervals.size()];
        for (int i = 0; i < intervals.size(); i++) {
            startArray[i] = intervals.get(i).start;
            endArray[i] = intervals.get(i).end;
        }
        Arrays.sort(startArray);
        Arrays.sort(endArray);

        /* In each interval in result, the next interval's start must be larger than current interval's end */
        for (int startIndex = 0, endIndex = 0; endIndex < intervals.size(); endIndex++) {
            if (endIndex == intervals.size() - 1 || startArray[endIndex + 1] > endArray[endIndex]) {
                res.add(new Interval(startArray[startIndex], endArray[endIndex]));
                startIndex = endIndex + 1;
            }
        }

        return res;
    }


}

/**
 * Intervals that contain two elements.
 * Start: start value.
 * End: end value.
 */
class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

