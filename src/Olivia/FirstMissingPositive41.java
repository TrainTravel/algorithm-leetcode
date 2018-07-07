package Olivia;

public class FirstMissingPositive41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length==0)
            return 1;
        //discard the non-positive part
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=0){
                nums[i] = nums.length+1;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i])<=nums.length){
                //要考虑到数字占用的情况
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                return i+1;
            }
        }
        return nums.length+1;

    }
}
