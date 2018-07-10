package Olivia;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateHelper(result, "", 0, 0, n);
        return result;
    }

    private void generateHelper(List<String> result, String str, int left, int right, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (left < max) {
            generateHelper(result, str + "(", left + 1, right, max);
        }
        if (right < left) {
            generateHelper(result, str + ")", left, right + 1, max);
        }
    }
}
