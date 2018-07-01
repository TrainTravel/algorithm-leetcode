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

        String s = "barfoothefoobarman" ;
        String [] words = new String[]{"foo", "bar"};
        FindSubstring30 test = new FindSubstring30();
        System.out.println(test.findSubstring(s,words));


    }
}