package LeetCodeSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/6/18
 * Time: 18:29
 */

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> combinationResult = new LinkedList<>();
        char[] digitArray = digits.toCharArray();
        if (digitArray.length == 0) {
            return combinationResult;
        }

        /* Map of digit to char */
        String[] two = {"a", "b", "c"};
        String[] three = {"d", "e", "f"};
        String[] four = {"g", "h", "i"};
        String[] five = {"j", "k", "l"};
        String[] six = {"m", "n", "o"};
        String[] seven = {"p", "q", "r", "s"};
        String[] eight = {"t", "u", "v"};
        String[] nine = {"w", "x", "y", "z"};

        for (int i = 0; i < digitArray.length; i++) {
            
        }

        return combinationResult;
    }
}
