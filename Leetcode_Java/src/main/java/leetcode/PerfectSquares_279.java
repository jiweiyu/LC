package leetcode;

import java.util.*;

public class PerfectSquares_279 {

    public int numSquares_dp(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<=n;i++){
            for(int j=1;i+j*j<=n;j++){
                dp[i+j*j]=Math.min(dp[i+j*j], dp[i]+1);
            }
        }
        return dp[n];
    }

    public int numSquares_bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.offer(0);
        visited.add(0);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            while(size-- > 0){
                int u = q.poll();
                for(int i=1;i*i<=n;i++){
                    int v = u+i*i;

                    if(v==n){
                        return depth;
                    }
                    if(v>n){
                        break;
                    }
                    if(!visited.contains(v)){
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }

        }
        return depth;

    }
}
