package Solution.Tree;

import Lib.NestedInteger;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * Weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.
 *
 * @author BorisMirage
 * Time: 2019/05/30 15:24
 * Created with IntelliJ IDEA
 */

public class DepthSumInverse_364 {
    /**
     * Iterate list, calculation process starts at root node.
     * During the iter process, from root to leaf node, the sum should be duplicated calculated as "layer".
     * root + root + root.next + root + root.next + root.next.next ...
     *
     * @param nestedList given nested list
     * @return sum of all integers in the list weighted by depth
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }

        int sum = 0;
        int previousSum = 0;

        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextLayer = new LinkedList<>();

            for (NestedInteger l : nestedList) {
                if (l.isInteger()) {
                    previousSum += l.getInteger();
                } else {
                    nextLayer.addAll(l.getList());
                }
            }
            sum += previousSum;
            nestedList = (nextLayer);
        }
        return sum;
    }
}
