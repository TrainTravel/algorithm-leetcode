package Solution.BFS;

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

        Queue<String> layer = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        layer.add(beginWord);

        while (!layer.isEmpty()) {
            int s = layer.size();

            for (int i = 0; i < s; i++) {
                String current = layer.remove();

                if (current.equals(endWord)) {
                    return result;
                }
                for (int j = 0; j < current.length(); j++) {
                    char[] arr = current.toCharArray();

                    for (char l = 'a'; l <= 'z'; l++) {
                        arr[j] = l;
                        String t = new String(arr);
                        if (wordSet.contains(t)) {

                            layer.offer(t);
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

    public static void main(String[] args) {
        String b = "hit";
        String e = "cog";
        List<String> l = new LinkedList<>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");

        LadderLength_127 test = new LadderLength_127();
        System.out.println(test.ladderLength(b, e, l));

        b = "a";
        e = "c";
        l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        test = new LadderLength_127();
        System.out.println(test.ladderLength(b, e, l));
    }
}
