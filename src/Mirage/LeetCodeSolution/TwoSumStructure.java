package Mirage.LeetCodeSolution;

import java.util.*;

/**
 * @author BorisMirage
 * Time: 2018/10/11 22:04
 * Created with IntelliJ IDEA
 */

public class TwoSumStructure {
    HashMap<Integer, Integer> temp;

    /**
     * Initialize your data structure here.
     */
    public TwoSumStructure() {
        temp = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int number) {
        temp.put(number, temp.getOrDefault(number, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            int i = entry.getKey();
            int j = value - i;

            /* Note that if there is only one element in the set, return false */
            if ((i == j && entry.getValue() > 1) || (i != j && temp.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}
