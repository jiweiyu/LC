package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        help(nums,res,new ArrayList<Integer>(), 0);
        return res;
    }

    public void help(int[] nums,
                     List<List<Integer>> res,
                     List<Integer> list,
                     int index){
        res.add(new ArrayList<Integer>(list));
        for(int i=index;i<nums.length;i++){
            //if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            help(nums,res,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
