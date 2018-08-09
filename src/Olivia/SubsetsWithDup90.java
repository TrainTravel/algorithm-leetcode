package Olivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            return result;
        Arrays.sort(nums);
        subsetHelper(nums,result,new ArrayList<>(),0);
        return result;
    }
    private void subsetHelper(int[] nums, List<List<Integer>> result, List<Integer> tmp, int startLoc){
        result.add(new ArrayList<>(tmp));
        for(int i=startLoc; i<nums.length;i++){
            /* i needs to larger than startLoc */
            if(i>startLoc&&nums[i]==nums[i-1])
                continue;
            tmp.add(nums[i]);
            subsetHelper(nums,result,tmp,i+1);
            tmp.remove(tmp.size()-1);
        }
    }

}
