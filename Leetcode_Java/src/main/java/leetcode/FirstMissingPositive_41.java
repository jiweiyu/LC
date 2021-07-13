package leetcode;

public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]<=0 || nums[i]>nums.length || nums[nums[i]-1] == nums[i]){
                i++;
            }else{
                swap(nums, i, nums[i]-1);
            }
        }
        i = 0;
        while(i<nums.length && nums[i]==i+1){
            i++;
        }
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }

    public int firstMissingPositive_(int[] nums) {

        /* arr can have atmost consecutive numbers of length = nums.length starting from index 1 */
        int[] arr = new int[nums.length+1];

        for(int i:nums)
        {
            /* we need only values >=1 and not more than length of consecutive numbers because if they are more than consecutive numbers length obviously there will be a value missing in between */
            if(i>=1 && i<=nums.length)
                arr[i]=1;
        }
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==0)
                return i;
        }

        /* if no value is missed i.e if given values are consecutive then next consecutive item should be returned */
        return nums.length+1;
    }
}
