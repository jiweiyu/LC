package bloomberg;

/**
 * Created by yujiwei on 18/7/5.
 */
public class moveZeroes_283 {


    //O(n^2)
    public void moveZeroes1(int[] nums) {
        if(nums.length <= 1){
            return;
        }

        for(int i = 0; i < nums.length;i++){
            for(int j= i+1; j < nums.length;j++){
                if(nums[i] == 0){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
    }

    //O(n)
    public void moveZeroes2(int[] nums) {
        if(nums.length <= 1){
            return;
        }

        int insertPlace = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[insertPlace++] = nums[i];
            }
        }

        while(insertPlace<nums.length){
            nums[insertPlace++] = 0;
        }

    }



}
