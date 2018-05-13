package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/12/18
 * Time: 20:40
 */

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        trans(s, numRows);
        return s;
    }

    public String[][] trans(String s, int numRows) {
        String result[][] = new String[s.length()][numRows];
        int strCount = 0;
        int row = 0;
        int column = 0;
        int touchBottom = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.toCharArray()[i];
            result[row][column] = Character.toString(current);

            if (row == numRows - 1) {
                touchBottom = 1;
            }
            if (row == 0 && column != 0) {
                touchBottom = 0;
            }
            if (touchBottom == 0) {
                row += 1;
            } else {
                row -= 1;
                column += 1;
            }
        }

        return result;
    }
}