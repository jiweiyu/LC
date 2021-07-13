package leetcode;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {

        if(nums==null || nums.length<2) return;

        int n = nums.length;

        k = k%n;

        int[] nums1 = new int[n-k];
        int[] nums2 = new int[k];
        for(int i=0;i<n-k;i++){
            nums1[i] = nums[i];
        }
        for(int i=k;i>0;i--){
            nums2[k-i] = nums[n-i];
        }

        for(int i=0;i<k;i++){
            nums[i]=nums2[i];
        }
        for(int i=k;i<n;i++){
            nums[i] = nums1[i-k];
        }
    }
}
