package Common;

/**
 * Intervals that contain two elements.
 * Start: start value.
 * End: end value.
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }
}
