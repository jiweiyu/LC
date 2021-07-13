package leetcode;

public class RemoveDuplicatesFromSortedArray_26 {

    public int removeDuplicates(int[] nums) {
        int i = 0, j=0;
        while(j<nums.length){

            if(i==0) nums[i++] = nums[j++];
            else{
                if(nums[j]>nums[j-1]) nums[i++]=nums[j++]; //i 1-2, j 2-3
                else{
                    j++;
                }
            }
        }
        return i;
    }
}
