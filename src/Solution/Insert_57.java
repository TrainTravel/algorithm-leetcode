package Solution;

import Lib.Interval;

import java.util.ArrayList;
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
     * The input intervals List has already sorted.
     * Hence, simply insert new Interval into correct position.
     *
     * @param intervals   interval list
     * @param newInterval new interval to be inserted
     * @return new interval list with input interval inserted
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();

        /* Special Case */
        if (intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }

        /* The first two conditions are non-overlapping situation */
        for (Interval currentInterval : intervals) {

            /* currentInterval is smaller than newInterval */
            if (newInterval == null || currentInterval.end < newInterval.start) {
                res.add(currentInterval);
            } else if (currentInterval.start > newInterval.end) {

                /* currentInterval is larger than newInterval  */
                res.add(newInterval);
                res.add(currentInterval);

                /* Set newInterval to null in order to avoid duplicate use */
                newInterval = null;

            } else {

                /* Overlapping condition: merge them and find correct position in later loop */
                newInterval.start = Math.min(currentInterval.start, newInterval.start);
                newInterval.end = Math.max(currentInterval.end, newInterval.end);
            }
        }

        /* In case newInterval should be at last of output list */
        if (newInterval != null) {
            res.add(newInterval);
        }

        return res;
    }
}
