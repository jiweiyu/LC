package leetcode;

public class JumpGameII_45 {
    public int jump(int[] nums){
        int curEnd = 0;
        int cufFarthest = 0;
        int jumpStep = 0;
        for(int i=0; i<nums.length-1;i++){
            cufFarthest = Math.max(cufFarthest, nums[i]+i);
            if(i==curEnd){
                jumpStep++;
                curEnd = cufFarthest;
            }
            if(curEnd>=nums.length-1){
                return jumpStep;
            }
        }
        return 0;
    }
}
