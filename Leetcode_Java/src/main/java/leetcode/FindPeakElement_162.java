package leetcode;

public class FindPeakElement_162 {

    public int findPeakElement_binarySearch(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l<r){
            int mid1 = (l+r)/2;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2]) l = mid2;
            else r = mid1;
        }
        return l;

    }

    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<end){
            if(nums[start+1]<nums[start]){
                return start;
            }else{
                start++;
            }
        }
        return end;
    }
}
