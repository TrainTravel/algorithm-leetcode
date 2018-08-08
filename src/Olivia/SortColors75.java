package Olivia;


public class SortColors75 {

    //a one-pass algorithm using only constant space
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i <= end; i++) {
            if (nums[i] == 0 && i != start) {
                swap(nums, i, start);
                start++;
                i--;
            } else if (nums[i] == 2 && i != end) {
                swap(nums, i, end);
                end--;
                i--;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
