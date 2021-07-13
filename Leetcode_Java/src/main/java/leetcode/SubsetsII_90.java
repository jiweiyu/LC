package leetcode;
import java.util.*;
public class SubsetsII_90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        help(nums,res, list, 0);
        return res;
    }

    public void help(int[] nums,
                     List<List<Integer>> res,
                     List<Integer> list,
                     int index){
        if(index<=nums.length) {
            res.add(list);
        }
        int i=index;
        while(i<nums.length){
            list.add(nums[i]);
            help(nums,res,new ArrayList<>(list),i+1);
            list.remove(list.size()-1);
            i++;
            while(i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
        }
    }
}
