package Mirage.LeetCodeSolution;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * @author BorisMirage
 * Time: 2018/10/02 18:55
 * Created with IntelliJ IDEA
 */

public class ShortestWordDistance_245 {
    /**
     * If two words are same, p1 = p2 as a length counter.
     *
     * @param words strings list
     * @param word1 first word in list
     * @param word2 second word in list
     * @return min distance between two words
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words.length == 0) {
            return -1;
        }
        int min = words.length + 1;
        int p1 = -1, p2 = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
            }
            if (words[i].equals(word2)) {
                if (word1.equals(word2)) {
                    p1 = p2;        // move pointer to previous one for counting same word distance
                }
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }

        return min;
    }
}
