package Solution.Backtracking;

import java.util.HashMap;

/**
 * Two players take turns to flip a string only contains "+" and "-".
 * Can only flip two consecutive "++" into "--".
 * Write a function to see if first player can win.
 *
 * @author BorisMirage
 * Time: 2019/06/07 21:46
 * Created with IntelliJ IDEA
 */

public class CanWin_294 {
    /**
     * Backtracking with hash map.
     *
     * @param s given string
     * @return if first player can win
     */
    public boolean canWin(String s) {
        if (s.length() < 2) {
            return false;
        }
        HashMap<String, Boolean> m = new HashMap<>();

        return backtracking(s.toCharArray(), m);
    }

    /**
     * Backtracking with hash map.
     * Iterate char array each time to find an action until reach the end.
     *
     * @param arr given string converted to char array
     * @param m   hash map
     * @return if first player can win based on current string
     */
    private boolean backtracking(char[] arr, HashMap<String, Boolean> m) {

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == '+' && arr[i - 1] == '+') {

                arr[i] = '-';       // flip
                arr[i - 1] = '-';

                boolean b;
                String key = String.valueOf(arr);

                if (!m.containsKey(key)) {
                    b = backtracking(arr, m);
                    m.put(key, b);
                } else {
                    b = m.get(key);
                }

                arr[i] = '+';
                arr[i - 1] = '+';

                if (!b) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanWin_294 test = new CanWin_294();
    }
}
