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
 * Convert each word in given array to char array, then sort the char array.
 * Next, convert the char array into string. This is the key of each word in hash map.
 * If two words are anagram, then they will have same key after sorting.
 *
 * @param strs input words array
 * @return linked list that contains each group of anagrams
 */
public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> out = new LinkedList<>();

    /* Corner case */
    if (strs.length == 0) {
        return out;
    }
    HashMap<String, List<String>> m = new HashMap<>();

    for (int i = 0; i < strs.length; i++) {

        char[] sortWord = strs[i].toCharArray();        // convert to char array to sort
        Arrays.sort(sortWord);
        String key = String.valueOf(sortWord);          // use sorted char as key in hash map

        if (m.containsKey(key)) {
            m.get(key).add(strs[i]);        // if the key is in map, append it to anagram group list
        } else {
            List<String> temp = new LinkedList<>();
            temp.add(strs[i]);
            m.put(key, temp);               // otherwise, put a new key and a new list into map
        }
    }

    out.addAll(m.values());
    return out;
}
}
