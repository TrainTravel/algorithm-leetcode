package src.Olivia;
import java.util.Arrays;

public class threeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        int cur = nums[0]+nums[1]+nums[nums.length-1];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int startLoc = i+1;
            int endLoc = nums.length-1;
            while(startLoc<endLoc){
                int now = nums[i] + nums[startLoc] + nums[endLoc];
                if(now>target){
                    endLoc--;
                }
                else {
                    startLoc++;
                }
                if(Math.abs(now-target)<Math.abs(cur-target)){
                    cur = now;
                }
            }
        }
        return cur;
    }
}
