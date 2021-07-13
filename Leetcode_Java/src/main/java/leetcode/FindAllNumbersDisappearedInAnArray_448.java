package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray_448 {

    //Negate each number while traversing
    //Run again and find the index that is not negated.
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List result = new ArrayList();
        for( int i=0;i< nums.length; i++){
            int index = nums[i];
            if(nums[Math.abs(index)-1] > 0){
                nums[Math.abs(index)-1]= -nums[Math.abs(index)-1];
            }
        }

        for(int j =1 ;j<nums.length;j++){
            result.add(j);
        }

        return result;
    }
}
