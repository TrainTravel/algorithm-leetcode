package Solution.Search;

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
     * Save each path while completing BFS using hash map.
     * Three Hash Sets are using in this solution:
     * 1. wordSet: save available words for next BFS search
     * 2. layer: save current layer words, update before each BFS search loop
     * 3. nextLayer: save current layer words, update in each BFS search loop
     * One Hash Map to store all possible path. Key is newest added word in path, value are all paths to this word.
     * Therefore, after each single word BFS, all old path based on this word should be removed to avoid repeated path.
     *
     * @param beginWord begin word
     * @param endWord   target word
     * @param wordList  middle words
     * @return all shortest transformation sequence(s) in ListNode
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        /* Corner case */
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return res;
        }

        /* First layer */
        Set<String> layer = new HashSet<>();        // save current layer words
        layer.add(beginWord);

        /* First path */
        HashMap<String, List<List<String>>> m = new HashMap<>();
        List<String> path = new LinkedList<>();
        path.add(beginWord);
        m.put(beginWord, new LinkedList<>());
        m.get(beginWord).add(path);

        boolean found = false;      // if endWord is reached, terminate searching loop

        while (!layer.isEmpty() && !wordSet.isEmpty() && !found) {
            wordSet.removeAll(layer);       // avoid repeated words
            Set<String> nextLayer = new HashSet<>();        // save next layer words
            for (String s : layer) {
                List<List<String>> currentPath = m.get(s);      // path based on current word

                /* BFS to find next layer */
                for (int i = 0; i < s.length(); i++) {
                    char[] arr = s.toCharArray();
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String w = new String(arr);
                        if (wordSet.contains(w)) {
                            nextLayer.add(w);

                            /* Iter all possible path and add word to its end */
                            for (List<String> p : currentPath) {
                                List<String> nextPath = new LinkedList<>(p);
                                nextPath.add(w);
                                m.putIfAbsent(w, new LinkedList<>());       // update key to current word
                                m.get(w).add(nextPath);                     // add path including current word
                                if (endWord.equals(w)) {
                                    res.add(nextPath);
                                    found = true;
                                }
                            }
                        }
                    }
                }
                m.remove(s);        // remove paths using previous layer's word as key, avoid repeated paths
            }

            /* Clear current layer and add next layer*/
            layer.clear();
            layer.addAll(nextLayer);
        }

        return res;
    }

    public static void main(String[] args) {
        String b = "hit";
        String e = "cog";
        List<String> l = new LinkedList<>();
        l.add("hot");
        l.add("lov");
        l.add("dog");
        l.add("lot");
        l.add("log");
        l.add("cog");

        FindLadders_126 test = new FindLadders_126();
        System.out.println(test.findLadders(b, e, l));

        b = "a";
        e = "c";
        l = new LinkedList<>();
        l.add("a");
        l.add("b");
        l.add("c");

        test = new FindLadders_126();
        System.out.println(test.findLadders(b, e, l));
    }
}
