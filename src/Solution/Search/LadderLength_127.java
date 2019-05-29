package Solution.Search;

import java.util.*;

/**
 * Given beginWord and endWord and a dictionary's word list.
 * Find the length of shortest transformation sequence from beginWord to endWord.
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * 1. Return 0 if there is no such transformation sequence.
 * 2. All words have the same length.
 * 3. All words contain only lowercase alphabetic characters.
 * 4. No duplicates in the word list. beginWord and endWord are non-empty and are different.
 *
 * @author BorisMirage
 * Time: 2019/05/28 16:24
 * Created with IntelliJ IDEA
 */

public class LadderLength_127 {
    /**
     * Use BFS to construct word. One char each time.
     *
     * @param beginWord begin word
     * @param endWord   target word
     * @param wordList  middle words
     * @return length of shortest transformation sequence
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 1;

        /* Corner case */
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return 0;
        }

        Queue<String> temp = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        temp.add(beginWord);

        while (!temp.isEmpty()) {
            int s = temp.size();

            for (int i = 0; i < s; i++) {
                String current = temp.remove();

                if (current.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < current.length(); j++) {
                    char[] arr = current.toCharArray();

                    for (char l = 'a'; l <= 'z'; l++) {
                        arr[j] = l;
                        String t = new String(arr);
                        if (wordSet.contains(t)) {

                            temp.offer(t);
                            // System.out.println("add!");
                            wordSet.remove(t);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
