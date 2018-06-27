package Mirage.Test;

import Mirage.LeetCodeSolution.*;
import Mirage.Playground.*;

import java.util.Arrays;


/**
 * Created with IntelliJ IDEA
 * Author: BorisMirage
 * Date: 6/15/18
 * Time: 21:25
 */

public class PlaygroundTest {
    public static void main(String[] args) {
//        QuickSort quickSortTest = new QuickSort();
//        int[] test = {0, 0, 0, 0, 1};
//        int[] x = {9, 2, 4, 7, 3, 7, 10};
//        int[] x1 = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
//        int[] x2 = {0, 0, 0, 0, 0, 0, 0, 0};
//        int[] x3 = {23, 6, 1, 9, 5, 3, 64, 3, 45, 6, 7, 8};
//        int[] x4 = {1};
//        int[] x5 = {};
//
//        System.out.println(Arrays.toString(test));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(test)));
//        System.out.println();
//        System.out.println(Arrays.toString(x));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x)));
//        System.out.println();
//        System.out.println(Arrays.toString(x1));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x1)));
//        System.out.println();
//        System.out.println(Arrays.toString(x2));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x2)));
//        System.out.println();
//        System.out.println(Arrays.toString(x3));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x3)));
//        System.out.println();
//        System.out.println(Arrays.toString(x4));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x4)));
//        System.out.println();
//        System.out.println(Arrays.toString(x5));
//        System.out.println(Arrays.toString(quickSortTest.QuickSort(x5)));
//
//
//        int[][] r = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        RotateMatrix rotateMatrixTest = new RotateMatrix();
//        rotateMatrixTest.rotateAntiClockwise(r);
//        System.out.println(r);

        AnagramCheck anagramCheckTest = new AnagramCheck();
        String s = "dog";
        String t = "nagaram";
//        System.out.println(anagramCheckTest.anagramCheck(s, t));

//        Anagram generateAnagramTest = new Anagram(s);
//        System.out.println(generateAnagramTest.findAll());

//        AnagramCheckWithHashMap anagramCheckWithHashMap = new AnagramCheckWithHashMap();
//        System.out.println(anagramCheckWithHashMap.isAnagram(s, t));

        Anagram anagramTest = new Anagram(s);
        System.out.println(anagramTest.findAnagram());
    }
}
