package Olivia;


import Mirage.LeetCodeSolution.FindSubstring;

public class Test {
    public static void main(String[] args) {

//        int[] height = new int[]{1,2,4,3};
//        MaxArea11 test = new MaxArea11();
//        System.out.println(test.maxArea(height));


      //  String s = "pwwkew";
        //LengthOfLongestSubstring3 test = new LengthOfLongestSubstring3();
       // System.out.println(test.lengthOfLongestSubstring(s));

      //  String s = "barfoothefoobarman" ;
      //  String [] words = new String[]{"foo", "bar"};
      //  FindSubstring30 test = new FindSubstring30();
      //  System.out.println(test.findSubstring(s,words));
        /* Valid Sudoku */
      IsValidSudoku36 isValidSudoku = new IsValidSudoku36();
      char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
               {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(isValidSudoku.isValidSudoku(board));


    }
}