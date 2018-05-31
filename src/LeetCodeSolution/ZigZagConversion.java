package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/12/18
 * Time: 20:40
 */

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        return trans(s, numRows);
    }

    public String trans(String s, int numRows) {
        String result[][] = new String[s.length()][numRows];

        /* Init array */
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < numRows; j++) {
                result[i][j] = null;
            }
        }
        int row = 0;
        int column = 0;
        int touchBottom = 0;

        for (int i = 0; i < s.length(); i++) {
            char current = s.toCharArray()[i];
            System.out.println(current);
            result[row][column] = Character.toString(current);

            if (row == numRows - 1) {
                touchBottom = 1;
            }
            if (row == 0) {
                touchBottom = 0;
            }
            if (touchBottom == 0) {
                row += 1;
            } else {
                row -= 1;
                column += 1;
            }
        }

        StringBuilder resultStrBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < numRows; j++) {
                if (result[i][j] != null) {
                    resultStrBuilder.append(result[i][j]);
                }
            }
        }

        return resultStrBuilder.toString();
    }
}