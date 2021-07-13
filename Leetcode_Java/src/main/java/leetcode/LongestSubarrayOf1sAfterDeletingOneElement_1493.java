package leetcode;
import java.util.*;
public class LongestSubarrayOf1sAfterDeletingOneElement_1493 {

    public int longestSubarray(int[] nums) {
        List<Integer> ind = new ArrayList<Integer>();
        int start = -1, end = -1;
        boolean zero = false;
        for(int i=0; i<nums.length;i++){
            if(nums[i] == 0) zero = true;
            if(start==-1 && nums[i]==1){
                start = i;
                end = i;
            }
            if(start > -1 && end > -1 && nums[i] == 0){
                ind.add(start);
                ind.add(end);
                start = -1;
                end = -1;
            }
            if(start > -1 && end > -1 && nums[i]==1){
                end = i;
            }
            if(start > -1 && end > -1 && i==nums.length-1){
                ind.add(start);
                ind.add(end);
            }
        }
        int res = 0, cur = 0;
        //System.out.println(ind);

        for(int i=0; i<ind.size(); i+=2){
            if(zero){
                cur = ind.get(i+1)-ind.get(i)+1;
                if(i+2<ind.size() && (ind.get(i+2)-ind.get(i+1)==2)){
                    cur = Math.max(cur, ind.get(i+1)-ind.get(i) + (ind.get(i+3) - ind.get(i+2)) + 2);
                }
            }else{
                if(i+2<ind.size() && (ind.get(i+2)-ind.get(i+1)==2)){
                    cur = Math.max(cur, ind.get(i+1)-ind.get(i) + (ind.get(i+3) - ind.get(i+2)) + 2);
                }else{
                    cur = Math.max(cur, ind.get(i+1)-ind.get(i));
                }
            }

            //System.out.println(cur);
            res = Math.max(res, cur);
        }
        return res;
    }

    //sliding window
    public int longestSubarray_slidingwindow(int[] A){
        int i = 0, j, k =1, res = 0;
        for(j = 0; j < A.length; j++){
            if(A[j] == 0){
                k--;
            }
            while(k<0){
                if(A[i]==0){
                    k++;
                }
                i++;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
