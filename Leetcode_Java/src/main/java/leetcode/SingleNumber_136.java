package leetcode;

public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int n : nums){
            res ^= n;
        }
        return res;
    }
}
