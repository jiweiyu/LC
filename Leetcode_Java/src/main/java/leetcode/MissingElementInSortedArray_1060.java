package leetcode;

public class MissingElementInSortedArray_1060 {

    public int missingElement(int[] nums, int k){
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int missingNum = nums[n-1] - nums[0]+1-n;

        if(missingNum<k){
            return nums[n-1]+k-missingNum;
        }

        while(l<h-1){
            int m = l+(h-l)/2;
            int missing = nums[m] - nums[l] - (m-l);
            if(missing >= k){
                h=m;
            }else{
                k=k-missing;
                l=m;
            }
        }
        return nums[l]+k;
    }

    public int missingElement_(int[] nums, int k) {
        for(int i=1;i<nums.length;i++){
            int diff = nums[i]-nums[i-1];
            if((k+1)>diff){
                k = k-(diff-1);
            }else{
                return nums[i-1]+k;
            }
        }
        if(k>0){
            return nums[nums.length-1]+k;
        }
        return nums[nums.length-1]+k;
    }

}


