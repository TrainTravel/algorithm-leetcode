package LeetCodeSolution;

/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 5/12/18
 * Time: 20:40
 */

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s.length() == 0) {
            return s;
        }
        if (s.length() == 1) {
            return s;
        }
        if (numRows==1){
            return s;
        }

        int numColumn = ((s.length() + 1) / 2) + numRows - 2;
        char[][] charArray = new char[numColumn][numRows];
        char[] sChar = s.toCharArray();
        int rowIndex = 0;
        int columnIndex = 0;
        int moveDown = 1;
        for (int i = 0; i < s.length(); i++) {
            charArray[columnIndex][rowIndex] = sChar[i];
            if (moveDown == 1) {
                if (rowIndex == numRows - 1) {
                    moveDown = 0;
                    rowIndex--;
                    columnIndex++;
                } else {
                    rowIndex++;
                }
            } else {
                if (rowIndex == 0) {
                    moveDown = 1;
                    rowIndex++;
                } else {
                    rowIndex--;
                    columnIndex++;
                }

            }
        }
        StringBuilder zigzag = new StringBuilder();
        for (int m = 0; m < numRows; m++) {
            for (int n = 0; n < numColumn; n++) {
                if (charArray[n][m] != '\u0000') {
                    zigzag.append(Character.toString(charArray[n][m]));

                }
            }
        }
        return zigzag.toString();
    }
}