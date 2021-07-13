package leetcode;

public class FindFirstAndLastPositionOfElementInSortedArray_34 {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[]{-1,-1};
        if(nums == null || n == 0 || nums[0]>target || nums[n-1]<target) return res;
        int l = 0, r = n-1;
        int target_ind = -1;
        while(l<=r){
            int i = l+(r-l)/2;
            if(nums[i]==target){
                target_ind = i;
                break;
            }else if(nums[i]>target){
                r = i-1;
            }else{
                l = i+1;
            }
        }
        if(target_ind >= 0){
            int res_left = target_ind,res_right = target_ind;
            while(res_left-1>=0 && nums[res_left-1]==target){
                res_left--;
            }
            while(res_right+1<n && nums[res_right+1]==target){
                res_right++;
            }
            res[0] = res_left;
            res[1] = res_right;
            return res;
        }else{
            return res;
        }
    }
}
