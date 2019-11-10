package Solution.Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei).
 * Find the minimum number of conference rooms required.
 *
 * @author BorisMirage
 * Time: 2019/06/28 17:35
 * Created with IntelliJ IDEA
 */
public class MinMeetingRooms_253 {
    /**
     * Since it is only the end time conflict that requires one more room, therefore, use a heap to save ending time.
     * They are several cases:
     * 1. Heap is empty
     * 2. two intervals has same start
     * 3. interval ends with a time smaller than top of heap (start before the other end)
     * 4. interval ends with a time larger than top of heap (start after the end)
     * 5. interval ends with a time smaller than top of heap
     * For situation 1,2,3, add current interval end to heap and one more room is required.
     * For situation 4, their is no conflict, hence add the end time to heap.
     * For situation 5, assume no extra room is required, continue, do nothing.
     *
     * @param intervals given time interval
     * @return minimum non-overlapped number
     */
    public int minMeetingRooms(int[][] intervals) {

        /* Corner case */
        if (intervals.length < 2) {
            return (intervals.length == 0) ? 0 : 1;
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));     // sort based on intervals[i][0]
        int count = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < intervals.length; i++) {
            if (q.isEmpty() || intervals[i][0] < q.peek() || intervals[i][0] == intervals[i - 1][0]) {
                q.offer(intervals[i][1]);
                count++;
            } else if (intervals[i][0] > q.peek()) {
                q.poll();
                q.offer(intervals[i][1]);
            }
        }
        return count;
    }

    /**
     * Sort start time and end time separately.
     * Then one pointer point at start time, one point at end time.
     * If start time < end time, then one more room is required.
     * Otherwise, there is no conflict, move end time pointer forward.
     *
     * @param intervals given time interval
     * @return minimum non-overlapped number
     */
    public int twoPointers(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, end = 0;

        for (int start : starts) {
            if (start < ends[end]) {
                rooms++;
            } else {
                end++;
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        MinMeetingRooms_253 test = new MinMeetingRooms_253();
        System.out.println(test.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(test.minMeetingRooms(new int[][]{{0, 5}, {5, 10}, {15, 20}}));
        System.out.println(test.minMeetingRooms(new int[][]{{7, 10}, {2, 4}, {15, 20}}));
        System.out.println(test.minMeetingRooms(new int[][]{{0, 30}, {0, 10}, {9, 20}}));
        System.out.println(test.minMeetingRooms(new int[][]{{6, 10}, {13, 14}, {12, 14}}));
        System.out.println(test.minMeetingRooms(new int[][]{{26, 29}, {19, 26}, {19, 28}, {4, 19}, {4, 25}}));      // 3
    }
}
