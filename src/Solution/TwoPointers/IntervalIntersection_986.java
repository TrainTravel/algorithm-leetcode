package Solution.TwoPointers;

import java.util.ArrayList;

/**
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 *
 * @author BorisMirage
 * Time: 2019/07/25 17:31
 * Created with IntelliJ IDEA
 */

public class IntervalIntersection_986 {
    /**
     * Two pointers, one point at A and one point at B. If there is interval, add result to list, otherwise move pointers.
     *
     * @param A first array
     * @param B second array
     * @return intersection of these two interval lists
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        int start, end;
        while (p1 < A.length && p2 < B.length) {

            start = Math.max(A[p1][0], B[p2][0]);
            end = Math.min(A[p1][1], B[p2][1]);
            if (end >= start) {
                int[] tmp = new int[2];
                tmp[0] = start;
                tmp[1] = end;
                res.add(tmp);
            }
            if (end == A[p1][1]) {
                p1++;
            } else {
                p2++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
