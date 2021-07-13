package leetcode;

public class ShuffleTheArray_1470 {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2*n];
        int idx = 0;
        for(int i=0; i<2*n; i=i+2){
            ans[i] = nums[idx];
            ans[i+1] = nums[idx + n];
            idx++;
        }
        return ans;
    }
}
