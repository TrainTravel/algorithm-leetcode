package Solution.Heap;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author BorisMirage
 * Time: 2020/02/20 15:22
 * Created with IntelliJ IDEA
 */

public class MedianFinder_295 {
    private Queue<Integer> small;
    private Queue<Integer> large;
    private boolean even = true;

    /**
     * Use two heaps.
     * Max heap stores smaller part of stream, min heap stores larger part of stream.
     */
    public MedianFinder_295() {
        small = new PriorityQueue<>((o1, o2) -> o2 - o1);               // max heap stores smaller part of stream
        large = new PriorityQueue<>();                                  // min heap stores larger part of stream
    }

    /**
     * Add number to heap.
     * Basic rule: add value to a heap, then poll out top of this heap and add this value to the other heap.
     * Size of small heap should be larger or equal to large heap.
     * This rule make findMedian() easier.
     * If total size is odd, then small heap is larger. Add value to large heap to make two heaps size equal.
     * Otherwise, add value to small heap. If findMedian() is called, return top of the small heap.
     * To add value, if add to small heap, first add value to large heap, then move top of large heap to small heap.
     *
     * @param num given integer
     */
    public void addNum(int num) {
        if (even) {     // if total size is even, then add value to large heap
            large.offer(num);
            small.offer(large.poll());      // move top of large heap (smallest in larger part of stream) to small heap
        } else {
            small.offer(num);
            large.offer(small.poll());      // move top of small heap to large heap
        }

        even = !even;
    }

    /**
     * If stream size is even, then return the average of two middle value in stream.
     * If stream size is odd, return value in the middle of stream, which is the top of small heap.
     * The reason is that, when adding value to heap, always keep small heap size larger or equal to large heap.
     *
     * @return median value in stream
     */
    public double findMedian() {
        if (even) {
            return (small.peek() + large.peek()) / 2.0;
        } else {
            return (double) small.peek();       // if total length is odd, then return top of small heap
        }
    }
}
