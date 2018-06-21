package Mirage.LeetCodeSolution;


import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/17/18
 * Time: 17:55
 */

public class FindSubstring {
    /**
     * You are given a string, s, and a list of words, words, that are all of the same length.
     * Find all starting indices of substring(s) in s
     * These indices are a concatenation of each word in words exactly once and without any intervening characters.
     *
     * @param s     input string
     * @param words input word list
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();

        /* Special Case */
        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        /* Key - char; Value: index */
        Map<Character, Integer> charMap = new IdentityHashMap<>();

        /* Put every char in hash map with their index as value for upcoming process */
        for (int i = 0; i < s.length(); i++) {
            charMap.put(s.charAt(i), i);
        }

        return res;
    }
}
