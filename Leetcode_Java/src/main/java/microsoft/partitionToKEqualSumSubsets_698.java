package microsoft;

import java.util.*;

public class partitionToKEqualSumSubsets_698 {

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if(row < 0){
            return true;
        }
        int v = nums[row--];
        for(int i = 0; i <groups.length; i++){
            if(groups[i] + v <= target){
                groups[i] += v;
                if(search(groups, row, nums, target)){
                    return true;
                }
                groups[i] -= v;
            }
            if(groups[i] == 0){
                break;
            }
        }
        return false;
    }

    public boolean canPartitionKSubsets_1(int[] nums, int k){
        int sum = Arrays.stream(nums).sum();
        if(sum % k > 0){
            return false;
        }
        int target = sum/k;

        Arrays.sort(nums);
        int row = nums.length - 1;
        if(nums[row] > target){
            return false;
        }
        while(row >= 0 && nums[row] == target){
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    // DP
    enum Result {TRUE, FALSE}

    public boolean carPartitionKSubsets_2(int[] nums, int k){
        int sum = Arrays.stream(nums).sum();
        if(sum%k > 0) return  false;

        Result[] memo = new Result[1 << nums.length];
        memo[(1<<nums.length)-1] = Result.TRUE;

        return search_(0, sum, memo, nums, sum/k);
    }

    boolean search_(int used, int todo, Result[] memo, int[] nums, int target){
        if(memo[used] == null){
            memo[used] = Result.FALSE;
            int targ = (todo - 1) % target + 1;
            for(int i = 0; i < nums.length; i++){
                if((((used >> i) & 1) == 0) && nums[i] <= targ){
                    if(search_(used | (1<<i), todo -nums[i], memo, nums, target)){
                        memo[used] = Result.TRUE;
                        break;
                    }
                }
            }
        }
        return memo[used] == Result.TRUE;
    }

    //DP + DFS, O(k * 2^n)
    public boolean canPartitionKSubsets_3(int[] nums, int k) {
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        if(k<=0 || sum%k!=0) return false;
        boolean[] visited = new boolean[nums.length];
        return help(nums,visited,0,k,0,sum/k);
    }

    public boolean help(int[] nums, boolean[] visited, int start_ind, int k, int cur_sum, int target){
        if(k==0) return true;
        if(cur_sum == target){
            return help(nums,visited,0,k-1,0,target);
        }

        for(int i=start_ind;i<nums.length;i++){
            if(!visited[i] && cur_sum+nums[i]<=target){
                visited[i]=true;
                if(help(nums,visited,i+1,k,cur_sum+nums[i], target)) return true;
                visited[i]=false;
            }
        }
        return false;
    }


}


