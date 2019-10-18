package Solution.BFS;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list.
 * Find all shortest transformation sequence(s) from beginWord to endWord.
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * 1. Return an empty list if there is no such transformation sequence.
 * 2. All words have the same length.
 * 3. All words contain only lowercase alphabetic characters.
 * 4. No duplicates in the word list. beginWord and endWord are non-empty and are different.
 *
 * @author BorisMirage
 * Time: 2019/05/29 10:59
 * Created with IntelliJ IDEA
 */

public class FindLadders_126 {
    /**
     * Save each path while completing BFS using hash map and two hash sets.
     * Hash map stores the path from begin word to current word.
     * Hash set stores all words in given word list and all words during each layer of BFS (to avoid duplication).
     * Each time, if word poll out from queue can form up a new word in list, add new word to the end of each list.
     * Based on character of BFS, if end word is reached, the path will be the shortest.
     *
     * @param beginWord begin word
     * @param endWord   target word
     * @param wordList  middle words
     * @return all shortest transformation sequence(s) in ListNode
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        /* Corner case */
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return new LinkedList<>();
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        HashMap<String, List<List<String>>> m = new HashMap<>();
        List<String> init = new LinkedList<>();
        init.add(beginWord);
        m.put(beginWord, new LinkedList<>());
        m.get(beginWord).add(init);
        boolean found = false;

        while (!q.isEmpty() && !wordSet.isEmpty() && !found) {
            int size = q.size();
            HashSet<String> current = new HashSet<>();      // save current layer's visited word

            for (int n = 0; n < size; n++) {
                String word = q.poll();
                List<List<String>> tmp = m.get(word);
                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    for (int j = 0; j < 26; j++) {

                        arr[i] = (char) (j + 'a');
                        String w = new String(arr);
                        if (wordSet.contains(w) && !w.equals(word) && tmp != null) {
                            q.add(w);
                            for (List<String> path : tmp) {
                                List<String> next = new LinkedList<>(path);
                                next.add(w);
                                m.putIfAbsent(w, new LinkedList<>());
                                m.get(w).add(next);
                                current.add(w);
                                found |= endWord.equals(w);
                            }
                        }
                    }
                }
                m.remove(word);
            }
            wordSet.removeAll(current);
        }

        return m.getOrDefault(endWord, new LinkedList<>());
    }

    public static void main(String[] args) {
        String b = "hit";
        String e = "cog";
        FindLadders_126 test = new FindLadders_126();
        List<String> l = new LinkedList<>();
        l.add("hot");
        l.add("lov");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");

        System.out.println(test.findLadders(b, e, l));

        b = "a";
        e = "c";
        l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        test = new FindLadders_126();
        System.out.println(test.findLadders(b, e, l));

        b = "red";
        e = "tax";
        l = new LinkedList<>();
        l.add("ted");
        l.add("tex");
        l.add("red");
        l.add("tax");
        l.add("tad");
        l.add("den");
        l.add("rex");
        l.add("pee");

        test = new FindLadders_126();
        System.out.println(test.findLadders(b, e, l));

        b = "hit";
        e = "cog";
        test = new FindLadders_126();
        l = new LinkedList<>();
        l.add("hot");
        l.add("dot");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");

        System.out.println(test.findLadders(b, e, l));
    }
}
