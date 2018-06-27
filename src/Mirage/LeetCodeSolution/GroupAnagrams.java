package Mirage.LeetCodeSolution;

import java.util.*;

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
        HashMap<String, List<String>> store = new HashMap<>();

        /* Iterate each word in strs */
        for (int i = 0; i < strs.length; i++) {

            /* Count each char's appearance in each word of strs */
            int[] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a'] += 1;
            }

            StringBuilder charAppearance = new StringBuilder();
            for (int k = 0; k < count.length; k++) {
                if (count[k] != 0) {
                    charAppearance.append((char) (k + 'a')).append(count[k]);
                }
            }

            if (store.containsKey(charAppearance.toString())) {
                store.get(charAppearance.toString()).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                store.put(charAppearance.toString(), temp);
            }
        }
        res.addAll(store.values());
        return res;
    }
}
