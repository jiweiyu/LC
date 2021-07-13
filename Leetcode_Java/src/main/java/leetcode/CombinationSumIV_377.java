package leetcode;
import java.util.*;
public class CombinationSumIV_377 {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] res = new int[target+1];
        for(int i=1;i<res.length;i++){
            for(int num: nums){
                if(num>i) break;
                else if(num == i){
                    res[i] += 1;
                }else{
                    res[i] += res[i-num];
                }
            }
        }
        return res[target];
    }

    //HashMap
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4_(int[] nums, int target) {
        int count = 0;
        if (nums == null || nums.length ==0 || target < 0 ) return 0;
        if ( target ==0 ) return 1;
        if (map.containsKey(target)) return map.get(target);
        for (int num: nums){
            count += combinationSum4_(nums, target-num);
        }
        map.put(target, count);
        return count;
    }

}
