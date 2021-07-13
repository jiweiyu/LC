package microsoft;

import java.util.*;

/*
给arr找出同时具有正负的数，并按顺序输出，如输入[1,4,-2,-1,-6,5,2]，输出[-2,-1,1,2]，其他数不满足有正负两个数存在
 */
public class positiveAndNagetiveNumber {

    public int[] solution(int[] nums){
        Arrays.sort(nums);

        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = nums.length-1;

        while( i < j){
            if(nums[i] == -1*nums[j]){
                res.add(nums[i++]);
                res.add(nums[j--]);
            }
            if(nums[i] < -1*nums[j]) i++;
            if(nums[j] > -1*nums[j]) j--;
        }

        int[] result = new int[res.size()];
        for(int x = 0; x < res.size(); x++){
            result[x] = res.get(x);
        }

        return result;
    }

}
