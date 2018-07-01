package Olivia;

import java.util.*;

/**
 * Created with IntelliJ IDEA
 * Author: Olivia
 * Date: 6/16/18
 * Time: 21:08
 */


public class TwoSum1 {
    //Original one
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    //Try two pass hash table
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        // TODO: Complete this method
        return result;
    }

    //Try one pass hash table
}



