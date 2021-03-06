package Solution.Intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author BorisMirage
 * Time: 2019/06/28 17:01
 * Created with IntelliJ IDEA
 */

public class CanAttendMeetings_252 {
    /**
     * Sort array first, then check if there is overlap that left bound is smaller than right bound.
     *
     * @param intervals given intervals
     * @return if there exists overlap.
     */
    public boolean canAttendMeetings(int[][] intervals) {

        /* Corner case */
        if (intervals == null || intervals.length == 0 || intervals.length == 1) {
            return true;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] tmp = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (tmp[1] > intervals[i][0]) {
                return false;
            }
            tmp = intervals[i];
        }

        return true;
    }

    public static void main(String[] args) {
        CanAttendMeetings_252 test = new CanAttendMeetings_252();
        System.out.println(test.canAttendMeetings(new int[][]{{0, 5}, {5, 10}, {15, 20}}));
        System.out.println(test.canAttendMeetings(new int[][]{{0, 30}, {5, 10}, {15, 20}}));

    }
}
