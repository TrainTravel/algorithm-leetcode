package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/30/18
 * Time: 17:19
 */

public class Merge {
    /**
     * Given a collection of intervals, merge all overlapping intervals.
     *
     * @param intervals input Interval list
     * @return merged result
     */
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();

        /* Special Case */
        if (intervals.size() < 2) {
            return intervals;
        }

        /* Sort list by start point */
        intervals.sort(Comparator.comparingInt(i -> i.start));        // Java 8 Lambda Comparator
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {

            /* Overlapping intervals.
             * Replace current end to new end */
            if (interval.start <= end) {
                end = Integer.max(end, interval.end);
            } else {

                /* Normal case, two intervals have no intersection or overlapping intervals has passed.
                 * Simply add current interval and set new start and end */
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
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

