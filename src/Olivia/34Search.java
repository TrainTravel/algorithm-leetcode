class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startLoc = 0;
        int endLoc = nums.length - 1;
        while(startLoc<=endLoc)
        {
            int cur = (startLoc+endLoc)/2;
            if(nums[cur]==target)
            {
                int[] result = new int[2];
                int begin = cur-1;
                int end = cur+1;
                while( begin > -1 && nums[begin] == target )
                { begin = begin - 1;}
                while ( end < nums.length&&nums[end] == target)
                { end = end + 1; }
                result[0] = begin+1;
                result[1] = end-1;
                return result;
            }
            if(nums[cur]>target)
            {endLoc = cur -1;}
            else
                startLoc = cur +1;
        }
        int[] tmp = new int[]{-1,-1};
        return tmp;
    }
}