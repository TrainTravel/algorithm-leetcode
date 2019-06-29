package Solution.Others;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.
 *
 * @author BorisMirage
 * Time: 2018/10/06 19:48
 * Created with IntelliJ IDEA
 */


public class Vector2D_251 implements Iterator<Integer> {
    private Iterator<List<Integer>> l;      // list iterator
    private Iterator<Integer> i;            // int iterator

    public Vector2D_251(List<List<Integer>> vec2d) {
        l = vec2d.iterator();
    }

    @Override
    public Integer next() {

        /* Find correct List<Integer> */
        hasNext();
        return i.next();
    }

    @Override
    public boolean hasNext() {
        while ((i == null || !i.hasNext()) && l.hasNext()) {
            i = l.next().iterator();        // next List<Integer> if current List<Integer> is traversed
        }
        return i != null && i.hasNext();        // 1. current List<Integer> is done. 2. all List<Integer> are done
    }


}
