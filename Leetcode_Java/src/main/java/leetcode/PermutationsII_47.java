package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class PermutationsII_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums,res,visited,new ArrayList<Integer>());
        return res;
    }

    public void helper(int[] nums,
                       List<List<Integer>> res,
                       boolean[] visited,
                       List<Integer> list){
        if(list.size()==nums.length){
            res.add(new ArrayList<Integer>(list));
        }

        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            //to make sure not choose 1b before 1a
            //[1,1,2]
            //[1a,1b,2a]
            //make sure 1b not be chosen before 1a
            if(i>0 && nums[i]==nums[i-1] && !visited[i-1]){
                continue;
            }
            list.add(nums[i]);
            visited[i]=true;
            helper(nums,res,visited,list);
            visited[i]=false;
            list.remove(list.size()-1);
        }
    }
}
