package Solution.Stack;

import java.util.Stack;

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

        Stack<Character> stack = new Stack<>();     // stack store the final available chars
        int[] count = new int[26];      // count char appearance
        boolean[] visited = new boolean[26];
        char[] arr = s.toCharArray();

        for (char c : arr) {
            count[c - 'a']++;
        }

        for (char c : arr) {
            count[c - 'a']--;

            if (visited[c - 'a']) {
                continue;       // pass chars already in stack to delete duplicated char
            }

            /*
             * Pop out elements that:
             * 1. larger than current char (to assure result smallest lexicographical order)
             * 2. this popped char should be found in later of string */
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;        // popped char may be seen in later of array
                stack.pop();
            }

            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
