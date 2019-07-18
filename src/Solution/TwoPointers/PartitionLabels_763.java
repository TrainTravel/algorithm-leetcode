package Solution.TwoPointers;

import java.util.*;

/**
 * A string S of lowercase letters is given.
 * Partition this string into as many parts as possible so that each letter appears in at most one part.
 * Return a list of integers representing the size of these parts.
 *
 * @author BorisMirage
 * Time: 2019/07/18 13:15
 * Created with IntelliJ IDEA
 */

public class PartitionLabels_763 {
    /**
     * First traverse the whole array, save the char's last appearance index.
     * Then use two pointers and traverse string.
     * First pointers points at the beginning of substring, second pointer points at the end of last char index.
     * Compare last index each time, find larger end index until traverse i == last. This is the length of substring.
     *
     * @param s given string
     * @return list of integers representing the size of these parts that each letter appears in at most one part
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> out = new LinkedList<>();

        /* Corner case */
        if (s.length() == 0) {
            return out;
        }

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }

        int last = 0;       // last index of char's appearance
        int start = 0;      // start position of sub string
        for (int i = 0; i < s.length(); i++) {

            last = Math.max(last, arr[s.charAt(i) - 'a']);

            if (last == i) {
                out.add(last - start + 1);
                start = last + 1;
            }
        }
        return out;
    }
}
