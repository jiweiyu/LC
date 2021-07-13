package leetcode;

import java.util.*;

public class CourseSchedule_207 {

    public boolean canFinish_topologies(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];
        List<Integer>[] goCourses = new List[numCourses];

        for(int i=0; i<goCourses.length; i++){
            goCourses[i] = new LinkedList<Integer>();
        }
        for(int[] pair : prerequisites){
            incomingEdges[pair[0]]++;
            goCourses[pair[1]].add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<incomingEdges.length;i++){
            if(incomingEdges[i] == 0){
                queue.add(i);
            }
        }
        int edgeCnt = prerequisites.length;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int goCrs : goCourses[cur]) {
                edgeCnt--;
                if (--incomingEdges[edgeCnt] == 0) {
                    queue.add(goCrs);
                }
            }
        }
        return edgeCnt == 0;

    }

    //BFS Topological Sorting, O(N + E)
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }
}
