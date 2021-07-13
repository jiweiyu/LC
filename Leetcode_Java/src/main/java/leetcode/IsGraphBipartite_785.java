package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {

    public boolean isBipartite_dfs(int[][] graph){
        int n = graph.length;
        int[] colors = new int[n];

        for(int i=0;i<n;i++){
            if(colors[i] == 0 && !validColor(graph, colors, 1, i)){
                return false;
            }
        }
        return true;
    }

    public boolean validColor(int[][] graph, int[] colors, int color, int node){
        if(colors[node] != 0){
            return colors[node] == color;
        }

        colors[node] = color;
        for(int next : graph[node]){
            if(!validColor(graph,colors,-color,next)){
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite_bfs(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];

        for(int i=0;i<len;i++){
            if(colors[i]!=0) continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;

            while(!queue.isEmpty()){
                int cur = queue.poll();
                for(int next : graph[cur]){
                    if(colors[next] == 0){
                        colors[next] = -colors[cur];
                        queue.offer(next);
                    }
                    else if(colors[next] != -colors[cur]){
                        return false;
                    }
                }
            }

        }
        return true;
    }

}
