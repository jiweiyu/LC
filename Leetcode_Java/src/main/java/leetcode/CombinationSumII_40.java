package leetcode;
import java.util.*;
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res,
                           List<Integer> list,
                           int[] candidates,
                           int target,
                           int start){
        if(target < 0) return;
        else if(target == 0) res.add(new ArrayList<>(list));
        else{
            for(int i=start;i<candidates.length;i++){
                if(i>start && candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                backtrack(res,list,candidates,target-candidates[i],i+1);
                list.remove(list.size()-1);
            }
        }

    }
}
