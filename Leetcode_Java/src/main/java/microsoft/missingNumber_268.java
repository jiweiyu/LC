package microsoft;


//Time O(n), Space O(1)
public class missingNumber_268 {

    //a^b^b = a
    public int missingNumber(int[] nums){
        int missing = nums.length;
        for(int i = 0 ; i< nums.length; i++){
            missing ^= i ^ nums[i];
        }
        return missing;
    }


}
