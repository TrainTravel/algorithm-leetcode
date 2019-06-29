package Solution.Anagram;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * @author BorisMirage
 * Time: 2018/06/25 10:14
 * Created with IntelliJ IDEA
 */

public class GroupAnagrams_49 {
    /**
     * Use hash map to identify.
     * Iterate strings. Convert word to char array and sort it.
     * Use this as key of map and a list to store all words has same key (anagram).
     *
     * @param strs input words array
     * @return linked list that contains each group of anagrams
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();

        /* Corner case */
        if (strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> store = new HashMap<>();

        /* Iterate each word in strs */
        for (int i = 0; i < strs.length; i++) {

            /* Sort current word in char array format and store this array as hashcode */
            char[] sortWord = strs[i].toCharArray();
            Arrays.sort(sortWord);
            String key = String.valueOf(sortWord);

            /* If key is in map, append current word to map's value, otherwise put new key and new list*/
            if (store.containsKey(key)) {
                store.get(key).add(strs[i]);
            } else {
                List<String> temp = new LinkedList<>();
                temp.add(strs[i]);
                store.put(key, temp);
            }
        }

        /* Put all anagrams group into output list */
        res.addAll(store.values());
        return res;
    }
}
