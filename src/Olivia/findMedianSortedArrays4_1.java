package Olivia;

public class findMedianSortedArrays4_1 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;
        int start1 = nums1[0];
        int end1 = nums1[m - 1];
        int start2 = nums2[0];
        int end2 = nums2[n - 1];
        int mid_l = (m+n)/2-1;
        int mid_r = (m+n)/2+1;
        if(end1<=start2){
            if(m<mid_l){
                return (nums1[mid_l-m]+nums1[mid_r-m])/2;
            }
            else{
                return
            }

        }

    }
    private double medianHelper (int[]nums1,int[]nums2, )
}
