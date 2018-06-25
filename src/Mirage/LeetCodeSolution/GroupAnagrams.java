package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/25/18
 * Time: 10:14
 */

public class GroupAnagrams {
    /**
     * Given an array of strings, group anagrams together.
     *
     * @param strs input words array
     * @return linked list that contains each group of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();

        /* Special Case */
        if (strs.length == 0) {
            return res;
        }

        return res;
    }
}
