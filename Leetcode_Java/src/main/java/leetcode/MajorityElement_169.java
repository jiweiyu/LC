package leetcode;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int num = nums[0];
        int count = 0;
        for(int val: nums){
            if(val == num){
                count++;
            }
            else if(count==0) {
                num = val;
                count++;
            }
            else {
                count--;
            }
        }
        return num;
    }
}
