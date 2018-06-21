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
     * You are given a string, s, and a list of words, words, that are all of the SAME LENGTH.
     * Find all starting indices of substring(s) in s
     * These indices are a concatenation of each word in words exactly once and without any intervening characters.
     * <p>
     * Use two map.
     * One map to record the expected times of each word and another map to record the times words have been seen.
     * Then check for every possible position of i.
     * Once an unexpected word was met or the times of some word is larger than its expected times, stop the check.
     * If check is finished successfully, push i to the result indexes.
     *
     * @param s     input string
     * @param words input word list
     * @return indices of word concatenation start
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new LinkedList<>();

        /* Special Case */
        if (s.length() == 0 || words.length == 0) {
            return res;
        }

        /* Record each word's appearance time. Key - word in String[] words; Value: appearance */
        final Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < s.length() - words[0].length() * words.length + 1; i++) {
            Map<String, Integer> stringMap = new HashMap<>();
            int j = 0;
            while (j < words.length) {

                /* All words in String[] words has same length */
                String currentSubstring = s.substring(i + j * words[0].length(), i + (j + 1) * words[0].length());

                /* Continue this while loop iff current sub string was found in wordMap */
                if (wordMap.containsKey(currentSubstring)) {

                    stringMap.put(currentSubstring, stringMap.getOrDefault(currentSubstring, 0) + 1);
                    if (stringMap.get(currentSubstring) > wordMap.getOrDefault(currentSubstring, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                res.add(i);
            }
        }
        return res;

//        final Map<String, Integer> wordsMap = new HashMap<>();
//        for (final String word : words) {
//            wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1);
//        }
//        final List<Integer> indexes = new ArrayList<>();
//        final int n = s.length(), num = words.length, len = words[0].length();
//        for (int i = 0; i < n - num * len + 1; i++) {
//            final Map<String, Integer> seen = new HashMap<>();
//            int j = 0;
//            while (j < num) {
//                final String word = s.substring(i + j * len, i + (j + 1) * len);
//                if (wordsMap.containsKey(word)) {
//                    seen.put(word, seen.getOrDefault(word, 0) + 1);
//                    if (seen.get(word) > wordsMap.getOrDefault(word, 0)) {
//                        break;
//                    }
//                } else {
//                    break;
//                }
//                j++;
//            }
//            if (j == num) {
//                indexes.add(i);
//            }
//        }
//        return indexes;

    }
}
