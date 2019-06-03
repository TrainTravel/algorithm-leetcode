package Solution.Search;

import Lib.NestedInteger;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * @author BorisMirage
 * Time: 2019/05/30 15:13
 * Created with IntelliJ IDEA
 */

public class DepthSum_339 {
    /**
     * Recursion with level until find individual number of nested list.
     *
     * @param nestedList given nested list
     * @return sum of all integers in the list weighted by depth
     */
    public int depthSum(List<NestedInteger> nestedList) {

        /* Corner case */
        if (nestedList == null) {
            return 0;
        }

        int sum = 0;
        int level = 1;
        return sum(nestedList, sum, level);
    }

    private int sum(List<NestedInteger> nestedList, int sum, int level) {
        for (NestedInteger i : nestedList) {
            if (i.isInteger()) {
                sum += level * i.getInteger();
            } else {
                sum = sum(i.getList(), sum, level + 1);
            }
        }
        return sum;
    }
}
