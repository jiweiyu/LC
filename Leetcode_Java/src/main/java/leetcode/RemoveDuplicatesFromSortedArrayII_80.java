package leetcode;

class reRemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int a : nums){
            if(i<2 || a>nums[i-2]){
                nums[i++] = a;
            }
        }
        return i;
    }

}
