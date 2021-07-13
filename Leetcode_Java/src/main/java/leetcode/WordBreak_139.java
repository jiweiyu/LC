package leetcode;

import java.util.*;

public class WordBreak_139 {

    public boolean wordBreak_BFS(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start]) {
                continue;
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end);
                    if (end == s.length()) {
                        return true;
                    }
                }
            }
            visited[start] = true;
        }
        return false;
    }

    public boolean wordBreak_DP(String s, Set<String> dict){
        if(s==null || s.length()==0) return false;
        int n = s.length();

        boolean[] dp = new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                String sub = s.substring(j,i+1);

                if(dict.contains(sub) && (j==0||dp[j-1])){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
