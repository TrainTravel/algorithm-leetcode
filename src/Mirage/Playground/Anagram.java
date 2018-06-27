package Mirage.Playground;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/26/18
 * Time: 17:10
 */

public class Anagram {
    private String find;

    public Anagram(String s) {
        find = s;
    }

    public List<String> findAnagram() {
        List<String> res = new LinkedList<>();

        /* Special Case */
        if (find.length() < 2) {
            return res;
        }
        char[] charArray = find.toCharArray();
        Arrays.sort(charArray);
        backtracking(charArray, new ArrayList<>(), res, new boolean[charArray.length]);

        return res;
    }

    private void backtracking(char[] charArray, List<Character> cache, List<String> res, boolean[] used) {
        if (cache.size() == charArray.length) {
            StringBuilder temp = new StringBuilder();
            for (Character ch : cache) {
                temp.append(ch);
            }
            res.add(temp.toString());
        } else {
            for (int i = 0; i < charArray.length; i++) {
                if (used[i] || i > 0 && charArray[i] == charArray[i - 1] && !used[i - 1]) {
                    continue;
                }
                cache.add(charArray[i]);
                used[i] = true;
                backtracking(charArray, cache, res, used);
                used[i] = false;
                cache.remove(cache.size() - 1);
            }
        }
    }
}
