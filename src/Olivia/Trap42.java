package Olivia;

public class Trap42 {
    public int trap(int[] height) {
        //special case for height has only two elements or less
        if(height.length<3)
            return 0;
        int leftMax = height[0];
        int rightMax = height[height.length-1];
        int left = 1;
        int right = height.length-2;
        int store = 0;
        //make sure the limit
        while(left<=right){
            if(leftMax <= rightMax){
                leftMax = Math.max(leftMax,height[left]);
                store += leftMax - height[left];
                left++;
            }
            else{
                rightMax = Math.max(rightMax,height[right]);
                store += rightMax - height[right];
                right--;
            }
        }
        return store;
    }
}
