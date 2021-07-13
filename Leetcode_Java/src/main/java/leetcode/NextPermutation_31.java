package leetcode;

public class NextPermutation_31 {

    //O(n)
    //O(1)
    public void nextPermutation(int[] num) {
        int n = num.length;
        if(n<2) return;
        int index = n-1;
        while(index>0){
            if(num[index-1]<num[index]) break;
            index--;
        }
        if(index==0){
            reverse(num, 0 , n-1);
            return;
        }else{
            int val = num[index-1];
            int j = n-1;
            while(j>=index){
                if(num[j]>val) break;
                j--;
            }
            swap(num,j,index-1);
            reverse(num,index,n-1);
            return;
        }
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums,i++,j--);
        }
    }

}
