package Mirage.LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth.
 * Format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 * Pack words in a greedy approach.
 * That is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * Extra spaces between words should be distributed as evenly as possible.
 * If number of spaces on a line do not divide evenly between words, left empty slots will be assigned more than right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * <p>
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * Input: words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation:
 * Note that the last line is "shall be    " instead of "shall     be".
 * The last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified because it contains only one word.
 *
 * @author BorisMirage
 * Time: 2018/08/07 14:35
 * Created with IntelliJ IDEA
 */

public class FullJustify {
    /**
     * Greedy approach.
     *
     * @param words    input word array
     * @param maxWidth max width
     * @return justified string list
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
        }
        return res;
    }
}
