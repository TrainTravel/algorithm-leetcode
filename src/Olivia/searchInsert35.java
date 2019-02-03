package Olivia;

public class searchInsert35 {
    public int searchInsert(int[] nums, int target) {
        //special case
        if(nums.length==0)
            return -1;
        if(target<=nums[0]){
            return 0;
        }
        int len = nums.length;
        int end = nums[len-1];
        if(target == end){
            return len-1;
        }
        if(target > end){
            return len;
        }
        int startloc = 0;
        int endloc = len-1;
        int result = 0;
        while(nums[startloc]<=nums[endloc]){
        int mid = (startloc+endloc)/2;
        if(target==nums[mid]){
            return mid;
        }
        else if(target>nums[mid]){
            startloc = mid +1;
        }
        else{
            endloc = mid - 1;
        }
        result = mid;
        }
        if(target>nums[result]){
            result += 1;
        }
        return result;
    }
}
