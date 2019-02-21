package Mirage.LeetCodeSolution;

/**
 * Given a list of words and two words word1 and word2.
 * Return the shortest distance between these two words in the list.
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 *
 * @author BorisMirage
 * Time: 2018/10/02 16:07
 * Created with IntelliJ IDEA
 */

public class ShortestDistance_243 {
    /**
     * Two pointers, first one point to word1 in list, second one point word2 in list.
     *
     * @param words strings list
     * @param word1 first word in list
     * @param word2 second word in list
     * @return min distance between two words
     */
    public int shortestDistance(String[] words, String word1, String word2) {
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
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        return min;
    }
}
