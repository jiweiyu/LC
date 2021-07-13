package leetcode;

public class CheckIfAll1sAreAtLeastLengthKPlacesAway_1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        int cur = -1;
        for(int i =0 ; i< nums.length;i++){
            if(nums[i]==1){
                cur = i;
                if(prev!=-1 && (cur-prev)<(k+1)){
                    //System.out.println("check : " + prev + "," + cur);
                    return false;
                }
                prev = i;
            }
        }
        //System.out.println("check : " + prev + "," + cur);
        return true;
    }
}
