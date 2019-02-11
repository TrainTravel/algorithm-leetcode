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
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            //need to check the repetition
            if(map.containsKey(target-nums[i])&&map.get(target-nums[i])!=i){
                result[0]=i;
                result[1]=map.get(target-nums[i]);
                return result;
            }
        }
        return null;
    }

    //Try one pass hash table
    public int[] twoSum2(int[] nums,int[] target){
        int[] result =new int[2];

    }

}



