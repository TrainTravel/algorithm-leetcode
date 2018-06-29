package Olivia;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations17 {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        findCombination(result, digits, "");
        return result;
    }

    private void findCombination(List<String> result, String input, String append) {
        String[] keyboardMap = new String[]{" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (append.length() == input.length()) {
            result.add(append);
            return;
        }
        String cur = keyboardMap[input.charAt(append.length()) - '0'];
        for (int i = 0; i < cur.length(); i++) {
            findCombination(result, input, append + cur.charAt(i));
        }
    }
}

