package Mirage.LeetCodeSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/6/18
 * Time: 18:29
 */

public class LetterCombinations {
    /**
     * Given a string containing digits from 2-9 inclusive.
     * Return all possible letter combinations that the number could represent.
     * The combination has same length as the digit length
     *
     * @param digits input digits
     * @return string array list that contains all possible combinations
     */
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();

        if (digits.equals("")) {
            return result;
        }

        /* First time calling function, the combination string is empty. */
        findCombination(digits, result, "");

        return result;
    }

    /**
     * Recursively find all combinations of digit letters.
     *
     * @param digit  input digit
     * @param result each step's result
     * @param s      each step's combination string
     */
    public void findCombination(String digit, ArrayList<String> result, String s) {

        /* Each key's representation */
        String[] keyboardMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        /* Ending point for this recursion */
        if (s.length() == digit.length()) {
            result.add(s);
            return;
        }

        /* Current string array item that is represented to the digit
         *  char - '0': to convert char digit to int digit, therefore to find letters in key array */
        String digitChar = keyboardMap[digit.charAt(s.length()) - '0'];

        /* Traverse every char in key array item */
        for (int i = 0; i < digitChar.length(); i++) {

            /* Each recursion will include one more char from key item,
               until combination length is equal to digit length */
            findCombination(digit, result, s + digitChar.charAt(i));
        }
    }
}
