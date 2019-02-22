package Solution.Structure;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Design a class which receives a list of words in the constructor.
 * Implements a method that takes two words and return the shortest distance between these two words in the list.
 * The method will be called repeatedly many times with different parameters.
 *
 * @author BorisMirage
 * Time: 2018/10/02 16:20
 * Created with IntelliJ IDEA
 */

public class WordDistance_244 {
    String[] words;
    HashMap<String, LinkedList<Integer>> store = new HashMap<>();

    /**
     * Init map.
     *
     * @param words given words list
     */
    public WordDistance_244(String[] words) {
        this.words = words;

        for (int i = 0; i < words.length; i++) {
            if (store.containsKey(words[i])) {
                store.get(words[i]).add(i);

            } else {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.add(i);
                store.put(words[i], temp);
            }
        }
    }

    /**
     * Get List that store in map and compare min distance.
     *
     * @param word1 first word in list
     * @param word2 second word in list
     * @return min distance between two words
     */
    public int shortest(String word1, String word2) {
        LinkedList<Integer> list1 = store.get(word1);
        LinkedList<Integer> list2 = store.get(word2);

        int min = words.length + 1;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (min == 1) {
                return 1;
            }
            int i1 = list1.get(i), i2 = list2.get(j);
            if (i1 < i2) {
                min = Math.min(min, i2 - i1);
                i++;
            } else {
                min = Math.min(min, i1 - i2);
                j++;
            }
        }
        return min;
    }
}
