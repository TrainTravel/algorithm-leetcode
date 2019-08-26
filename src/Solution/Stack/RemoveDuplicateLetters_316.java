package Solution.Stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given a string which contains only lowercase letters.
 * Remove duplicate letters so that every letter appear once and only once.
 * Make sure your result is the smallest in lexicographical order among all possible results.
 *
 * @author BorisMirage
 * Time: 2019/06/28 14:25
 * Created with IntelliJ IDEA
 */

public class RemoveDuplicateLetters_316 {
    /**
     * First, iterate the array to count each char's appearance.
     * Then iterate this array again.
     * If found a char has been in stack, pass this char. Delete this char to keep in smallest lexicographical order.
     * If found a char that is smaller than top of stack, pop it if this top char has more than one appearance in array.
     * The purpose of this process is to assure output result is in smallest lexicographical order.
     * Stack is not to store temporary char during first iteration, it is to store final output result.
     *
     * @param s given string
     * @return string without duplicated letter and be smallest in lexicographical order
     */
    public String removeDuplicateLetters(String s) {

        /* Corner case */
        if (s.length() == 0) {
            return "";
        }

        Deque<Character> dq = new LinkedList<>();       // use deque instead of stack for better string forming
        boolean[] isVisited = new boolean[26];
        int[] count = new int[26];                      // count char appearance
        char[] arr = s.toCharArray();

        for (char c : arr) {
            count[c - 'a']++;
        }

        for (char c : arr) {
            count[c - 'a']--;

            if (!isVisited[c - 'a']) {      // pass chars already in stack and in this way to delete duplicated char

                /*
                 * Pop out elements that:
                 * 1. Larger than current char (to assure result smallest lexicographical order)
                 * 2. This popped char will be found in later of string (count[c] > 0)
                 * Both conditions should be met. */
                while (!dq.isEmpty() && dq.peekLast() > c && count[dq.peekLast() - 'a'] > 0) {
                    isVisited[dq.pollLast() - 'a'] = false;     // popped char may be seen in later of array
                }
                dq.addLast(c);
                isVisited[c - 'a'] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
        }
        return sb.toString();
    }
}
