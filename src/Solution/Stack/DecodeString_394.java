package Solution.Stack;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * @author BorisMirage
 * Time: 2019/06/26 18:02
 * Created with IntelliJ IDEA
 */

public class DecodeString_394 {
    /**
     * Use two stacks to store the repeat time and previous substring when a # of repeat time is found.
     * When a ']' is found, concatenate repeat substring to previous non-repeat substring.
     * The concatenated string will be the next repeating part, or becomes the final result if no repetition is found.
     *
     * @param s given encoded string
     * @return decoded string
     */
    public String decodeString(String s) {

        Stack<Integer> repeat = new Stack<>();      // save repeat time
        Stack<String> temp = new Stack<>();     // save temporary string
        String out = "";
        int i = 0;

        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i) - '0');
                    i++;
                }
                repeat.push(count);     // add repeat time to stack
            } else if (s.charAt(i) == '[') {
                temp.push(out);     // add previous decoded string to stack for later repeat process
                out = "";       // reset to record next string clip
                i++;
            } else if (s.charAt(i) == ']') {

                /*
                 * Top of the stack is the substring before repeat count.
                 * Add this part to StringBuilder and then add repeat part to the end of it. */
                StringBuilder cache = new StringBuilder(temp.pop());
                int count = repeat.pop();
                for (int j = 0; j < count; j++) {
                    cache.append(out);      // concatenate repeat substring to previous non-repeat substring
                }

                /*
                 * Now this string will have two possibility:
                 * 1. Becomes the repetition of previous part, and will be reset after repetition is completed.
                 * 2. Be reset and push to stack when a new '[' is found. */
                out = cache.toString();
                i++;
            } else {
                out += s.charAt(i++);       // if current char is normal alphabet, continue add it to the end of output
            }
        }
        return out;
    }

    public static void main(String[] args) {
        DecodeString_394 test = new DecodeString_394();
        System.out.println(test.decodeString("3[a2[c]]"));
    }
}
